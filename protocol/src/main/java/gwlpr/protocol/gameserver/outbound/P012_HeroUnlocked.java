
package gwlpr.protocol.gameserver.outbound;

import gwlpr.protocol.serialization.GWMessage;


/**
 * Auto-generated by PacketCodeGen.
 * 
 */
public final class P012_HeroUnlocked
    extends GWMessage
{

    private short heroID;
    private short profession;
    private long nPCFile;
    private long modelFile;
    private short unknown1;

    @Override
    public short getHeader() {
        return  12;
    }

    public void setHeroID(short heroID) {
        this.heroID = heroID;
    }

    public void setProfession(short profession) {
        this.profession = profession;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("P012_HeroUnlocked[");
        sb.append("heroID=").append(this.heroID).append(",profession=").append(this.profession).append(",nPCFile=").append(this.nPCFile).append(",modelFile=").append(this.modelFile).append(",unknown1=").append(this.unknown1).append("]");
        return sb.toString();
    }

}
