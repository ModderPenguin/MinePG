package rpg.items;

import rpg.client.renderers.items.RenderItemTrainingStaff;
import rpg.config.base.mage.MageWeapons;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;


public class ItemModelRegisters {
    
    public static void registerItemModelRenderers() {
        MinecraftForgeClient.registerItemRenderer(MageWeapons.staffTraining.itemID, (IItemRenderer)new RenderItemTrainingStaff());
    }
}
