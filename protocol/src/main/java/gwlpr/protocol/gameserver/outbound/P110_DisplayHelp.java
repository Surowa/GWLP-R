
package gwlpr.protocol.gameserver.outbound;

import gwlpr.protocol.serialization.GWMessage;


/**
 * Auto-generated by PacketCodeGen.
 * 
 */
public final class P110_DisplayHelp
    extends GWMessage
{

    private long localID;
    private String text;
    private long time;
    private long imageFile;
    private long unknown1;

    @Override
    public short getHeader() {
        return  110;
    }

    public void setLocalID(long localID) {
        this.localID = localID;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setImageFile(long imageFile) {
        this.imageFile = imageFile;
    }

    public void setUnknown1(long unknown1) {
        this.unknown1 = unknown1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("P110_DisplayHelp[");
        sb.append("localID=").append(this.localID).append(",text=").append(this.text.toString()).append(",time=").append(this.time).append(",imageFile=").append(this.imageFile).append(",unknown1=").append(this.unknown1).append("]");
        return sb.toString();
    }

}
