package rpg.config.base.mage;

import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import rpg.RPG;
import rpg.config.RPGCreativeTabs;
import rpg.config.RPGMaterials;
import rpg.items.armor.mage.MageTrainingArmor;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MageArmor {

    static int hatTrainingID;
    static int robeTrainingID;
    static int sandalsTrainingID;

    public static Item hatTraining;
    public static Item robeTraining;
    public static Item sandalsTraining;

    public static void addNames() {
        LanguageRegistry.addName(hatTraining, "Training Hat");
        LanguageRegistry.addName(robeTraining, "Training Robe");
        LanguageRegistry.addName(sandalsTraining, "Training Sandals");
    }

    public static void load(Configuration config) {
        hatTrainingID = config.get(Configuration.CATEGORY_ITEM,
                "Training Helm ID", 1005).getInt();
        robeTrainingID = config.get(Configuration.CATEGORY_ITEM,
                "Training Robe ID", 1006).getInt();
        sandalsTrainingID = config.get(Configuration.CATEGORY_ITEM,
                "Training Sandals ID", 1007).getInt();

        hatTraining = new MageTrainingArmor(hatTrainingID,
                RPGMaterials.trainingArmor, RPG.proxy.addArmor("mageTraining"),
                0, "hatTraining").setCreativeTab(RPGCreativeTabs.tabMageItems);
        robeTraining = new MageTrainingArmor(robeTrainingID,
                RPGMaterials.trainingArmor, RPG.proxy.addArmor("mageTraining"),
                1, "robeTraining").setCreativeTab(RPGCreativeTabs.tabMageItems);
        sandalsTraining = new MageTrainingArmor(sandalsTrainingID,
                RPGMaterials.trainingArmor, RPG.proxy.addArmor("mageTraining"),
                3, "sandalsTraining")
                .setCreativeTab(RPGCreativeTabs.tabMageItems);
    }
}
