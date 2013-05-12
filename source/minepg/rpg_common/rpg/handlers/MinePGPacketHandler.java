package rpg.handlers;

import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet131MapData;
import rpg.network.packet.MinePGPacket;

import com.google.common.io.ByteStreams;

import cpw.mods.fml.common.network.ITinyPacketHandler;

public class MinePGPacketHandler implements ITinyPacketHandler {

    @Override
    public void handle(NetHandler handler, Packet131MapData mapData) {
        MinePGPacket.execute(ByteStreams.newDataInput(mapData.itemData),
                mapData.uniqueID, handler.getPlayer());
    }
}