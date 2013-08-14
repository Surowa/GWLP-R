
package gwlpr.protocol.gameserver.inbound;

import gwlpr.protocol.serialization.GWMessage;


/**
 * Auto-generated by PacketCodeGen.
 * 
 */
public final class P003_PingReply
    extends GWMessage
{

    private long latency;

    @Override
    public short getHeader() {
        return  3;
    }

    public long getLatency() {
        return latency;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("P003_PingReply[");
        sb.append("latency=").append(this.latency).append("]");
        return sb.toString();
    }

}
