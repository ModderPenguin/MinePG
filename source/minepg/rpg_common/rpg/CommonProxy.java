package rpg;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import rpg.client.entities.EntityWandTrainingBolt;
import rpg.gui.GuiHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.EntityRegistry;

public class CommonProxy implements IGuiHandler {
	public void registerRenderers() {
	}
	
	public void init() {
		registerRenderers();
		
		EntityRegistry.registerGlobalEntityID(EntityWandTrainingBolt.class, "TrainingBolt", EntityRegistry.findGlobalUniqueEntityId());
	}

	public GuiHandler guiHandler = new GuiHandler();

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return guiHandler.getServerGuiElement(ID, player, world, x, y, z);
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	public int addArmor(String name){
		return RenderingRegistry.addNewArmourRendererPrefix(name);
	}
}
