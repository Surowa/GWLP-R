
package gwlpr.protocol.gameserver.outbound;

import gwlpr.protocol.serialization.GWMessage;


/**
 * Auto-generated by PacketCodeGen.
 * This is used to add a hero to the pull down menu
 * in the party window.
 * 
 */
public final class P103_HeroUpdate
    extends GWMessage
{

    private int heroID;
    private short level;
    private short primaryProf;
    private short secondaryProf;
    private long nPCFile;
    private long modelFile;
    private short unknown1;
    private short isDisabled;

    @Override
    public short getHeader() {
        return  103;
    }

    public void setHeroID(int heroID) {
        this.heroID = heroID;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public void setPrimaryProf(short primaryProf) {
        this.primaryProf = primaryProf;
    }

    public void setSecondaryProf(short secondaryProf) {
        this.secondaryProf = secondaryProf;
    }

    public void setNPCFile(long nPCFile) {
        this.nPCFile = nPCFile;
    }

    public void setModelFile(long modelFile) {
        this.modelFile = modelFile;
    }

    public void setUnknown1(short unknown1) {
        this.unknown1 = unknown1;
    }

    public void setIsDisabled(short isDisabled) {
        this.isDisabled = isDisabled;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("P103_HeroUpdate[");
        sb.append("heroID=").append(this.heroID).append(",level=").append(this.level).append(",primaryProf=").append(this.primaryProf).append(",secondaryProf=").append(this.secondaryProf).append(",nPCFile=").append(this.nPCFile).append(",modelFile=").append(this.modelFile).append(",unknown1=").append(this.unknown1).append(",isDisabled=").append(this.isDisabled).append("]");
        return sb.toString();
    }

}
