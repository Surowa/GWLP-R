
package gwlpr.protocol.loginserver.inbound;

import gwlpr.protocol.serialization.GWMessage;


/**
 * Auto-generated by PacketCodeGen.
 * 
 */
public final class P006_Unknown
    extends GWMessage
{

    private long unknown1;
    private long unknown2;

    @Override
    public short getHeader() {
        return  6;
    }

    public long getUnknown1() {
        return unknown1;
    }

    public long getUnknown2() {
        return unknown2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("P006_Unknown[");
        sb.append("unknown1=").append(this.unknown1).append(",unknown2=").append(this.unknown2).append("]");
        return sb.toString();
    }

}
