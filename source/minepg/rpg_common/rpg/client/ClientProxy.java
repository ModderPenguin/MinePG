package rpg.client;

import java.io.File;

import cpw.mods.fml.client.registry.RenderingRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import rpg.CommonProxy;
import rpg.client.entities.EntityWandTrainingBolt;
import rpg.client.gui.GuiChooseStarter;
import rpg.client.renderers.RenderWandTrainingBolt;
import rpg.enums.EnumGui;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityWandTrainingBolt.class, new RenderWandTrainingBolt());
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == EnumGui.ChooseStarter.getIndex())
			return new GuiChooseStarter();

		return null;
	}
}