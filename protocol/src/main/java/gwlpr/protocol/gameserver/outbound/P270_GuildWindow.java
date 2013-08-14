
package gwlpr.protocol.gameserver.outbound;

import java.util.Arrays;
import gwlpr.protocol.serialization.GWMessage;
import gwlpr.protocol.util.IsArray;


/**
 * Auto-generated by PacketCodeGen.
 * This can be used to apply a guild created with
 * "P279_GuildGeneral":https://github.com/GameRevision/GWLP-R/wiki/P279_GuildGeneral
 * to the guild window.
 * 
 */
public final class P270_GuildWindow
    extends GWMessage
{

    private int localID;
    @IsArray(constant = true, size = 16, prefixLength = -1)
    private byte[] guildHallData;
    private short memberType;

    @Override
    public short getHeader() {
        return  270;
    }

    public void setLocalID(int localID) {
        this.localID = localID;
    }

    public void setGuildHallData(byte[] guildHallData) {
        this.guildHallData = guildHallData;
    }

    public void setMemberType(short memberType) {
        this.memberType = memberType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("P270_GuildWindow[");
        sb.append("localID=").append(this.localID).append(",guildHallData=").append(Arrays.toString(this.guildHallData)).append(",memberType=").append(this.memberType).append("]");
        return sb.toString();
    }

}
