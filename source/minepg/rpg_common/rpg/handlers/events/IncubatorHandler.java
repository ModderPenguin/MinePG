package rpg.handlers.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent;

public class IncubatorHandler {
    
    @ForgeSubscribe
    public void incubateEgg(LivingEvent event){
        if(event.entity instanceof EntityPlayer) {            
            // if(TileEntityPetEgg.sholdIncubate) {
                // int timer = TileEntityPetEgg.incubatingTimer;
                // timer++;
                // if (timer >= TileEntityPet.getIncubationTime()) {
                    // new PacketSpawnPet().sendToServer();
                    System.out.println("Incubation finishes in: " + /* timer + */ "EntityPlayer dUpdates");
                // }
            // }
        }
    }
}
