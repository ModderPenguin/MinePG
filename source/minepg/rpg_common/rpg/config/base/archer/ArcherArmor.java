package rpg.config.base.archer;

import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import rpg.RPG;
import rpg.config.RPGCreativeTabs;
import rpg.config.RPGMaterials;
import rpg.items.armor.archer.ArcherTrainingArmor;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ArcherArmor {

    static int tunicTrainingID;
    static int legsTrainingID;
    static int bootsTrainingID;

    public static Item tunicTraining;
    public static Item legsTraining;
    public static Item bootsTraining;

    public static void addNames() {
        LanguageRegistry.addName(tunicTraining, "Training Tunic");
        LanguageRegistry.addName(legsTraining, "Training Leggings");
        LanguageRegistry.addName(bootsTraining, "Training Boots");
    }

    public static void load(Configuration config) {
        tunicTrainingID = config.get(Configuration.CATEGORY_ITEM,
                "Training Tunic ID", 1002).getInt();
        legsTrainingID = config.get(Configuration.CATEGORY_ITEM,
                "Training Pants ID", 1003).getInt();
        bootsTrainingID = config.get(Configuration.CATEGORY_ITEM,
                "Training Shoes ID", 1004).getInt();

        tunicTraining = new ArcherTrainingArmor(tunicTrainingID,
                RPGMaterials.trainingArmor,
                RPG.proxy.addArmor("archerTraining"), 1, "tunicTraining")
                .setCreativeTab(RPGCreativeTabs.tabArcherItems);
        legsTraining = new ArcherTrainingArmor(legsTrainingID,
                RPGMaterials.trainingArmor,
                RPG.proxy.addArmor("archerTraining"), 2, "legsTraining")
                .setCreativeTab(RPGCreativeTabs.tabArcherItems);
        bootsTraining = new ArcherTrainingArmor(bootsTrainingID,
                RPGMaterials.trainingArmor,
                RPG.proxy.addArmor("archerTraining"), 3, "bootsTraining")
                .setCreativeTab(RPGCreativeTabs.tabArcherItems);
    }
}
