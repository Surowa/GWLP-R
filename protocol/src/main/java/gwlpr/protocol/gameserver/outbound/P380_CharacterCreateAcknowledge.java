
package gwlpr.protocol.gameserver.outbound;

import gwlpr.protocol.serialization.GWMessage;


/**
 * Auto-generated by PacketCodeGen.
 * 
 */
public final class P380_CharacterCreateAcknowledge
    extends GWMessage
{


    @Override
    public short getHeader() {
        return  380;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("P380_CharacterCreateAcknowledge[");
        sb.append("]");
        return sb.toString();
    }

}
