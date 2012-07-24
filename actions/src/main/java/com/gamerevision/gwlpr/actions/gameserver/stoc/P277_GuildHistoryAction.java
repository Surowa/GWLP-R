/**
 * For copyright information see the LICENSE document.
 */

/**
 * Auto-generated by PacketCodeGen, on 2012-07-19
 */

package com.gamerevision.gwlpr.actions.gameserver.stoc;

import com.realityshard.shardlet.GenericAction;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * This is an automatically generated ShardletAction.
 * It resembles the packet template that has been 
 * parsed from our packet templates xml.
 *
 *
 * @author GWLPR Template Updater
 */
public final class P277_GuildHistoryAction extends GenericAction
{

    private int date;
    private char[] entry;


    public short getHeader()
    {
        return 277;
    }


    /**
     * The number of days since 12/31/1899 
     */
    public void setDate(int newValue)
    {
        date = newValue;
    }


    public void setEntry(char[] newValue)
    {
        entry = newValue;
    }


    private int getSize()
    {
        int size = 8;

        if (entry != null)
        {
            size += 2 * entry.length;
        }

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

            buffer.putInt(date);
            short prefix_entry;
            if (entry == null)
            {
                prefix_entry = 0;
            }
            else
            {
                prefix_entry = (short) entry.length;
            }
            buffer.putShort(prefix_entry);
            
            for (int i = 0; i < prefix_entry; i++)
            {
                buffer.putChar(entry[i]);
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