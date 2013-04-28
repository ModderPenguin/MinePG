package rpg.comm;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

public abstract class PixelmonPacket extends Packet250CustomPayload
{
	EnumPackets packetType;
	
	public Packet getPacket()
    {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        DataOutputStream data = new DataOutputStream(bytes);
        try
        {
            data.writeInt(getID());
            writePacketData(data);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Packet250CustomPayload pkt = new Packet250CustomPayload();
        pkt.channel = "Pixelmon";
        pkt.data    = bytes.toByteArray();
        pkt.length  = pkt.data.length;
        return pkt;
    }

	@Override
	public abstract void writePacketData(DataOutputStream par1DataOutputStream) throws IOException;
	@Override
	public abstract void readPacketData(DataInputStream par1DataInputStream) throws IOException;

	public abstract int getID();
    public String toString(boolean full)
    {
        return toString();
    }

    @Override
    public String toString()
    {
        return getID() + " " + getClass().getSimpleName();
    }
}
