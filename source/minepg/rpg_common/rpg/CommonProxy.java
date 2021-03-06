package rpg;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import rpg.blocks.tileentity.TileEntityPetEgg;
import rpg.client.entities.projectiles.EntityStaffTrainingBolt;
import rpg.gui.GuiHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy implements IGuiHandler {

    public GuiHandler guiHandler = new GuiHandler();

    public int addArmor(String name) {
        return RenderingRegistry.addNewArmourRendererPrefix(name);
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return this.guiHandler.getServerGuiElement(ID, player, world, x, y, z);
    }

    public void init() {
        this.registerRenderers();

        EntityRegistry.registerGlobalEntityID(EntityStaffTrainingBolt.class, "TrainingBolt", EntityRegistry.findGlobalUniqueEntityId());
    }

    public void registerKeyBindings() {

    }

    public void registerRenderers() {
    }

    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityPetEgg.class, "petEggEntity");
    }
}
