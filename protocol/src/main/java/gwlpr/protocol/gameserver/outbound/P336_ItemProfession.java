
package gwlpr.protocol.gameserver.outbound;

import gwlpr.protocol.serialization.GWMessage;


/**
 * Auto-generated by PacketCodeGen.
 * 
 */
public final class P336_ItemProfession
    extends GWMessage
{

    private long itemLocalID;
    private short profession;

    @Override
    public short getHeader() {
        return  336;
    }

    public void setItemLocalID(long itemLocalID) {
        this.itemLocalID = itemLocalID;
    }

    public void setProfession(short profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("P336_ItemProfession[");
        sb.append("itemLocalID=").append(this.itemLocalID).append(",profession=").append(this.profession).append("]");
        return sb.toString();
    }

}
