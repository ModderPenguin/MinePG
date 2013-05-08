package rpg.config.base.warrior;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import rpg.enums.EnumRPGToolMaterial;
import rpg.enums.weapons.EnumRPGWaraxeMaterial;
import rpg.items.warrior.weapons.ItemTrainingSword;
import rpg.items.warrior.weapons.ItemTrainingWaraxe;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class WarriorWeapons {

    static int waraxeTrainingID;
    static int swordTrainingID;
    
	public static Item waraxeTraining;
	public static Item swordTraining;
	
	public static void load(Configuration config) {
	    waraxeTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training WarAxe ID", 1016).getInt();
        swordTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Sword ID", 1017).getInt();
        
        waraxeTraining = new ItemTrainingWaraxe(waraxeTrainingID, EnumRPGWaraxeMaterial.TRAINING, 100, 1, "waraxeTraining").setCreativeTab(CreativeTabs.tabCombat);
        swordTraining = new ItemTrainingSword(swordTrainingID, EnumRPGToolMaterial.TRAINING, "swordTraining").setCreativeTab(CreativeTabs.tabCombat);
	}
	
	public static void addNames() {
	    LanguageRegistry.addName(waraxeTraining, "Training Waraxe");
		LanguageRegistry.addName(swordTraining, "Training Sword");
	}
}
