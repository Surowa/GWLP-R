/**
 * For copyright information see the LICENSE document.
 */

/**
 * Auto-generated by PacketCodeGen, on 2012-05-28
 */

package com.gamerevision.gwlpr.actions.loginserver.stoc;

import com.realityshard.shardlet.GenericAction;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/**
 * This is an automatically generated ShardletAction.
 * It resembles the packet template that has been 
 * parsed from our packet templates xml.
 *
 * Auto generated 
 *
 * @author GWLPR Template Updater
 */
public final class P031_UnknownAction extends GenericAction
{

    private int unknown1;
    private List<Integer> unknown2;
    private List<Integer> unknown3;


    public short getHeader()
    {
        return 31;
    }


    public void setUnknown1(int newValue)
    {
        unknown1 = newValue;
    }


    public void setUnknown2(List<Integer> newValue)
    {
        unknown2 = newValue;
    }


    public void setUnknown3(List<Integer> newValue)
    {
        unknown3 = newValue;
    }


    private int getSize()
    {
        int size = 10;

        if (unknown2 == null)
        {
            return 0;
        }
        
        size += 4 * unknown2.size();
        if (unknown3 == null)
        {
            return 0;
        }
        
        size += 4 * unknown3.size();

        return size;
    }


    @Override
    public boolean serialize()
    {
        int size = getSize();

        if (size == 0)
        {
            return false;
        }

        ByteBuffer buffer = ByteBuffer.allocate(size).order(ByteOrder.LITTLE_ENDIAN);

        try
        {
            buffer.putShort(getHeader());

            buffer.putInt(unknown1);
            short prefix_unknown2 = (short) unknown2.size();
            buffer.putShort(prefix_unknown2);
            
            for (int i = 0; i < prefix_unknown2; i++)
            {
                buffer.putInt(unknown2.get(i));
            }
            short prefix_unknown3 = (short) unknown3.size();
            buffer.putShort(prefix_unknown3);
            
            for (int i = 0; i < prefix_unknown3; i++)
            {
                buffer.putInt(unknown3.get(i));
            }
        }
        catch (BufferOverflowException e)
        {
            return false;
        }

        setBuffer(buffer);

        return true;
    }
}