package rpg.config.base.warrior;

import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import rpg.RPG;
import rpg.config.RPGCreativeTabs;
import rpg.config.RPGMaterials;
import rpg.items.armor.warrior.WarriorTrainingArmor;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class WarriorArmor {

    static int helmetTrainingID;
    static int cuirassTrainingID;
    static int greavesTrainingID;
    static int sabatonsTrainingID;

    public static Item helmetTraining;
    public static Item cuirassTraining;
    public static Item greavesTraining;
    public static Item sabatonsTraining;

    public static void addNames() {
        LanguageRegistry.addName(helmetTraining, "Training Helmet");
        LanguageRegistry.addName(cuirassTraining, "Training Cuirass");
        LanguageRegistry.addName(greavesTraining, "Training Greaves");
        LanguageRegistry.addName(sabatonsTraining, "Training Sabatons");
    }

    public static void load(Configuration config) {
        helmetTrainingID = config.get(Configuration.CATEGORY_ITEM,
                "Training Helmet ID", 1008).getInt();
        cuirassTrainingID = config.get(Configuration.CATEGORY_ITEM,
                "Training Cuirass ID", 1009).getInt();
        greavesTrainingID = config.get(Configuration.CATEGORY_ITEM,
                "Training Greaves ID", 1010).getInt();
        sabatonsTrainingID = config.get(Configuration.CATEGORY_ITEM,
                "Training Sabatons ID", 1011).getInt();

        helmetTraining = new WarriorTrainingArmor(helmetTrainingID,
                RPGMaterials.trainingArmor,
                RPG.proxy.addArmor("warriorTraining"), 0, "helmetTraining")
                .setCreativeTab(RPGCreativeTabs.tabWarriorItems);
        cuirassTraining = new WarriorTrainingArmor(cuirassTrainingID,
                RPGMaterials.trainingArmor,
                RPG.proxy.addArmor("warriorTraining"), 1, "cuirassTraining")
                .setCreativeTab(RPGCreativeTabs.tabWarriorItems);
        greavesTraining = new WarriorTrainingArmor(greavesTrainingID,
                RPGMaterials.trainingArmor,
                RPG.proxy.addArmor("warriorTraining"), 2, "greavesTraining")
                .setCreativeTab(RPGCreativeTabs.tabWarriorItems);
        sabatonsTraining = new WarriorTrainingArmor(sabatonsTrainingID,
                RPGMaterials.trainingArmor,
                RPG.proxy.addArmor("warriorTraining"), 3, "sabatonsTraining")
                .setCreativeTab(RPGCreativeTabs.tabWarriorItems);
    }
}
