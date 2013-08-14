
package gwlpr.protocol.gameserver.outbound;

import gwlpr.protocol.serialization.GWMessage;


/**
 * Auto-generated by PacketCodeGen.
 * 
 */
public final class P173_AddMissionGoal
    extends GWMessage
{

    private String goal;
    private long type;

    @Override
    public short getHeader() {
        return  173;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public void setType(long type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("P173_AddMissionGoal[");
        sb.append("goal=").append(this.goal.toString()).append(",type=").append(this.type).append("]");
        return sb.toString();
    }

}
