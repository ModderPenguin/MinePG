package rpg.handlers.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent;
import rpg.blocks.tileentity.TileEntityPetEgg;
import rpg.network.packet.PacketSpawnPet;

public class IncubatorHandler {
    
    @ForgeSubscribe
    public void incubateEgg(LivingEvent event){
        if(event.entity instanceof EntityPlayer) {
            if(TileEntityPetEgg.canIncubate) {
                int timer = TileEntityPetEgg.incubatingTimer;
                timer++;
                if (timer >= TileEntityPetEgg.getIncubationTime()) {
                    new PacketSpawnPet(event.entity.worldObj, TileEntityPetEgg.petType).sendToServer();
                    System.out.println("Incubation finishes in: " +  timer + "EntityPlayer Updates");
                }
                if(timer == TileEntityPetEgg.getIncubationTime()) {
                    TileEntityPetEgg.incubatingTimer = 0;
                }
            }
        }
    }
}