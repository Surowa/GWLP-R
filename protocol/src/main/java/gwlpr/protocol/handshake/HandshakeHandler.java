/**
 * For copyright information see the LICENSE document.
 */

package gwlpr.protocol.handshake;

import gwlpr.protocol.serialization.GWMessageSerializationRegistry;
import static gwlpr.protocol.serialization.GWMessageSerializationRegistry.register;
import gwlpr.protocol.serialization.NettySerializationFilter;
import realityshard.container.util.EncryptionUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.nio.ByteOrder;
import java.security.SecureRandom;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import realityshard.container.network.GameAppContextKey;
import realityshard.container.network.RC4Codec;


/**
 * Handshake is basically the same for LS and GS,
 * just the first packets that are sent differ (client version and verify client)
 * 
 * This is full of magic numbers, but the actual classes cant be stuffed with the
 * shit, as they need to be serializable!
 * 
 * @author _rusty
 */
public class HandshakeHandler extends ByteToMessageDecoder
{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HandshakeHandler.class);
    
    /**
     * Expected length of the next packet (this is more or less the header)
     */
    private int expectedLength;
    private IN1_VerifyClient verifyClient = null;

    
    /**
     * Static Constructor.
     */
    static 
    {
        register(IN1_ClientVersion.class);
        register(IN1_VerifyClient.class);
        register(IN2_ClientSeed.class);
        register(OUT_ServerSeed.class);
    }
    
    
    /**
     * Constructor.
     * 
     * @param       expectedLength          Length of first expected packet
     */
    private HandshakeHandler(int expectedLength)
    {
        this.expectedLength = expectedLength;
    }
    
    
    /**
     * Factory method.
     */
    public static HandshakeHandler produceLoginHandshake()
    {
        return new HandshakeHandler(new IN1_ClientVersion().getHeader());
    }
    
    
    /**
     * Factory method.
     */
    public static HandshakeHandler produceGameHandshake()
    {
        return new HandshakeHandler(new IN1_VerifyClient().getHeader());
    }
    
    
    @Override
    protected void decode(final ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception 
    {
        if (in.readableBytes() < 16 + 66) { return; }
        
        LOGGER.debug(String.valueOf(in.readableBytes()));
        
        switch (expectedLength)
        {
            case 1024: // client version:
                {
                    in.order(ByteOrder.BIG_ENDIAN);
                
                    LOGGER.debug(String.valueOf(in.readShort()));
                    
                    in.order(ByteOrder.LITTLE_ENDIAN);
                    
                    // deserialize the packet
                    NettySerializationFilter filter = GWMessageSerializationRegistry.getFilter(IN1_ClientVersion.class);
                    IN1_ClientVersion clientVersion = new IN1_ClientVersion();
                    filter.deserialize(in, clientVersion);
                    
                    LOGGER.debug(String.format("Got the client version: %d", clientVersion.getClientVersion()));
                } 
                break;
                
            case 1280: // verify client:
                {
                    in.order(ByteOrder.BIG_ENDIAN);
                
                    LOGGER.debug(String.valueOf(in.readShort()));
                    
                    in.order(ByteOrder.LITTLE_ENDIAN);
                    
                    // deserialize the packet
                    NettySerializationFilter filter = GWMessageSerializationRegistry.getFilter(IN1_VerifyClient.class);
                    verifyClient = new IN1_VerifyClient();
                    filter.deserialize(in, verifyClient);
                    
                    LOGGER.debug("Got the verify client packet.");
                } 
                break;
        }

        // server seed:
        in.order(ByteOrder.BIG_ENDIAN);
                
        LOGGER.debug(String.valueOf(in.readShort()));

        in.order(ByteOrder.LITTLE_ENDIAN);

        LOGGER.debug("Got the client seed packet.");

        // deserialize the packet
        NettySerializationFilter filter = GWMessageSerializationRegistry.getFilter(IN2_ClientSeed.class);
        IN2_ClientSeed clientSeed = new IN2_ClientSeed();
        filter.deserialize(in, clientSeed);

        // generate the shared key
        byte[] sharedKeyBytes = EncryptionUtils.generateSharedKey(clientSeed.getClientPublicKey());

        // start RC4 key generation
        byte[] randomBytes = new byte[20];
        new SecureRandom().nextBytes(randomBytes);
        final byte[] rc4Key = EncryptionUtils.hash(randomBytes);

        // encrypt the RC4 key before sending it to the client
        byte[] xoredRandomBytes = EncryptionUtils.XOR(randomBytes, sharedKeyBytes);

        // we can set the RC4 decoder now...
        RC4Codec.Decoder decoder = new RC4Codec.Decoder(rc4Key);
        ctx.pipeline().addFirst(decoder);

        // now send the server seed packet
        OUT_ServerSeed serverSeed = new OUT_ServerSeed();
        serverSeed.setEncryptedRC4Key(xoredRandomBytes);
        
        ByteBuf seed = ctx.alloc().buffer(70);
        seed.order(ByteOrder.BIG_ENDIAN);
        seed.writeShort(22);
        seed.order(ByteOrder.LITTLE_ENDIAN);
        
        filter = GWMessageSerializationRegistry.getFilter(OUT_ServerSeed.class);
        filter.serialize(seed, serverSeed);
        
        ChannelFuture cf = ctx.writeAndFlush(seed);

        // also remove this handler
        ctx.pipeline().remove(this);

        // set the RC4 encoder only after the serverseed packet has been send!
        cf.addListener(new ChannelFutureListener() 
        {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception 
            {
                // add the rc4 codec
                RC4Codec.Encoder encoder = new RC4Codec.Encoder(rc4Key);
                ctx.pipeline().addFirst(encoder);

                // tell the channel's context that handshake has been done
                ctx.channel().attr(GameAppContextKey.KEY).get().trigger(
                        new HandShakeDoneEvent(verifyClient));
            }
        });
    }
}
