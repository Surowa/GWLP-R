
package gwlpr.protocol.gameserver.inbound;

import gwlpr.protocol.serialization.GWMessage;


/**
 * Auto-generated by PacketCodeGen.
 * 
 */
public final class P032_Unknown
    extends GWMessage
{

    private long agentID1;
    private long unknown2;
    private long unknown3;
    private short unknown4;

    @Override
    public short getHeader() {
        return  32;
    }

    public long getAgentID1() {
        return agentID1;
    }

    public long getUnknown2() {
        return unknown2;
    }

    public long getUnknown3() {
        return unknown3;
    }

    public short getUnknown4() {
        return unknown4;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("P032_Unknown[");
        sb.append("agentID1=").append(this.agentID1).append(",unknown2=").append(this.unknown2).append(",unknown3=").append(this.unknown3).append(",unknown4=").append(this.unknown4).append("]");
        return sb.toString();
    }

}
