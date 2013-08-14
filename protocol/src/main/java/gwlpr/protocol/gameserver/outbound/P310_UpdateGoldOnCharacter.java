
package gwlpr.protocol.gameserver.outbound;

import gwlpr.protocol.serialization.GWMessage;


/**
 * Auto-generated by PacketCodeGen.
 * 
 */
public final class P310_UpdateGoldOnCharacter
    extends GWMessage
{

    private int streamID;
    private long gold;

    @Override
    public short getHeader() {
        return  310;
    }

    public void setStreamID(int streamID) {
        this.streamID = streamID;
    }

    public void setGold(long gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("P310_UpdateGoldOnCharacter[");
        sb.append("streamID=").append(this.streamID).append(",gold=").append(this.gold).append("]");
        return sb.toString();
    }

}
