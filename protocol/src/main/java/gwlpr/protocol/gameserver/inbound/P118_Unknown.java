
package gwlpr.protocol.gameserver.inbound;

import gwlpr.protocol.serialization.GWMessage;


/**
 * Auto-generated by PacketCodeGen.
 * 
 */
public final class P118_Unknown
    extends GWMessage
{

    private long unknown1;
    private int unknown2;
    private short unknown3;

    @Override
    public short getHeader() {
        return  118;
    }

    public long getUnknown1() {
        return unknown1;
    }

    public int getUnknown2() {
        return unknown2;
    }

    public short getUnknown3() {
        return unknown3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("P118_Unknown[");
        sb.append("unknown1=").append(this.unknown1).append(",unknown2=").append(this.unknown2).append(",unknown3=").append(this.unknown3).append("]");
        return sb.toString();
    }

}
