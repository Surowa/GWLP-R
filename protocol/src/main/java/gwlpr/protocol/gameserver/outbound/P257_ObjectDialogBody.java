
package gwlpr.protocol.gameserver.outbound;

import gwlpr.protocol.serialization.GWMessage;


/**
 * Auto-generated by PacketCodeGen.
 * 
 */
public final class P257_ObjectDialogBody
    extends GWMessage
{

    private String body;

    @Override
    public short getHeader() {
        return  257;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("P257_ObjectDialogBody[");
        sb.append("body=").append(this.body.toString()).append("]");
        return sb.toString();
    }

}
