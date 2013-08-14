
package gwlpr.protocol.gameserver.outbound;

import gwlpr.protocol.serialization.GWMessage;


/**
 * Auto-generated by PacketCodeGen.
 * 
 */
public final class P451_PartyCreate
    extends GWMessage
{

    private int partyId;

    @Override
    public short getHeader() {
        return  451;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("P451_PartyCreate[");
        sb.append("partyId=").append(this.partyId).append("]");
        return sb.toString();
    }

}
