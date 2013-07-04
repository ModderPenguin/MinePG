package rpg.config.base.warrior.paladin;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import rpg.enums.weapons.EnumHammerMaterial;
import rpg.items.warrior.weapons.ItemHammer;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class PaladinWeapons {

    static int hammerTrainingID;

    public static Item hammerTraining;

    public static void addNames() {
        LanguageRegistry.addName(hammerTraining, "Training Hammer");
    }

    public static void load(Configuration config) {
        hammerTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Staff ID", 1018).getInt();

        hammerTraining = new ItemHammer(hammerTrainingID, EnumHammerMaterial.TRAINING, 1, "hammerTraining").setCreativeTab(CreativeTabs.tabCombat);
    }
}
