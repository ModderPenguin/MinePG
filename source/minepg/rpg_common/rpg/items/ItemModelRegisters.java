package rpg.items;

import net.minecraftforge.client.MinecraftForgeClient;
import rpg.client.renderers.items.RenderItemTrainingStaff;
import rpg.config.base.mage.MageWeapons;

public class ItemModelRegisters {

    public static void registerItemModelRenderers() {
        MinecraftForgeClient
                .registerItemRenderer(MageWeapons.staffTraining.itemID,
                        new RenderItemTrainingStaff());
    }
}
