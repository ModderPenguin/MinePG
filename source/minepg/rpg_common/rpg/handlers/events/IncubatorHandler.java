package rpg.handlers.events;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent;
import rpg.blocks.tileentity.TileEntityPetEgg;
import rpg.network.packet.PacketSpawnPet;

public class IncubatorHandler {

	@ForgeSubscribe
	public void incubateEgg(LivingEvent event){
		TileEntityPetEgg petEgg = new TileEntityPetEgg();
		if(petEgg.canIncubate) {
			int timer = petEgg.getIncubatingTimer();
			timer++;
			if (timer >= petEgg.getIncubationTime()) {
				new PacketSpawnPet(event.entity.worldObj, petEgg.petType).sendToServer();
				System.out.println("Incubation finishes in: " +  timer + "EntityPlayer Updates");
			}
			if(timer == petEgg.getIncubationTime()) {
				petEgg.setIncubatingTimer(0);
			}
		}
	}
}