package rpg.config.knight;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import rpg.enums.EnumRPGToolMaterial;
import rpg.items.knight.weapons.ItemTrainingSword;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class KnightWeapons {
	
	static int swordTrainingID;
	
	public static Item swordTraining;
	
	public static void load(Configuration config) {
		swordTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Sword ID", 1017).getInt();
		
		swordTraining = new ItemTrainingSword(swordTrainingID, EnumRPGToolMaterial.TRAINING, "swordTraining").setCreativeTab(CreativeTabs.tabCombat);
	}
	
	public static void addNames() {
		LanguageRegistry.addName(swordTraining, "Training Sword");
	}
}
