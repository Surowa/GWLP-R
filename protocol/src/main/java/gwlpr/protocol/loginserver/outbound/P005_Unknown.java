
package gwlpr.protocol.loginserver.outbound;

import gwlpr.protocol.serialization.GWMessage;


/**
 * Auto-generated by PacketCodeGen.
 * 
 */
public final class P005_Unknown
    extends GWMessage
{

    private long unknown1;
    private String unknown2;
    private String unknown3;
    private String unknown4;
    private String unknown5;
    private String unknown6;
    private String unknown7;
    private String unknown8;

    @Override
    public short getHeader() {
        return  5;
    }

    public void setUnknown1(long unknown1) {
        this.unknown1 = unknown1;
    }

    public void setUnknown2(String unknown2) {
        this.unknown2 = unknown2;
    }

    public void setUnknown3(String unknown3) {
        this.unknown3 = unknown3;
    }

    public void setUnknown4(String unknown4) {
        this.unknown4 = unknown4;
    }

    public void setUnknown5(String unknown5) {
        this.unknown5 = unknown5;
    }

    public void setUnknown6(String unknown6) {
        this.unknown6 = unknown6;
    }

    public void setUnknown7(String unknown7) {
        this.unknown7 = unknown7;
    }

    public void setUnknown8(String unknown8) {
        this.unknown8 = unknown8;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("P005_Unknown[");
        sb.append("unknown1=").append(this.unknown1).append(",unknown2=").append(this.unknown2 .toString()).append(",unknown3=").append(this.unknown3 .toString()).append(",unknown4=").append(this.unknown4 .toString()).append(",unknown5=").append(this.unknown5 .toString()).append(",unknown6=").append(this.unknown6 .toString()).append(",unknown7=").append(this.unknown7 .toString()).append(",unknown8=").append(this.unknown8 .toString()).append("]");
        return sb.toString();
    }

}