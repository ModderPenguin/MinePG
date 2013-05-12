package rpg.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import rpg.CommonProxy;
import rpg.client.entities.EntityWandTrainingBolt;
import rpg.client.gui.GuiChooseClass;
import rpg.client.gui.GuiLoreStartingPage;
import rpg.client.keybindings.PlayerStatsKey;
import rpg.client.renderers.RenderWandTrainingBolt;
import rpg.enums.EnumGui;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {
        if (ID == EnumGui.ChooseClass.getIndex())
            return new GuiChooseClass();
        else if (ID == EnumGui.LoreStartingPage.getIndex())
            return new GuiLoreStartingPage();

        return null;
    }

    @Override
    public void registerKeyBindings() {

        KeyBindingRegistry.registerKeyBinding(new PlayerStatsKey());
    }

    @Override
    public void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(
                EntityWandTrainingBolt.class, new RenderWandTrainingBolt());
    }
}