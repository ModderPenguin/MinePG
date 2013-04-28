package rpg.config.sorcerer;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import rpg.enums.EnumRPGWandMaterial;
import rpg.items.sorcerer.weapons.ItemTrainingWand;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SorcererWeapons {

	static int wandTrainingID;
	
	public static Item wandTraining;
	
	public static void load(Configuration config) {
		wandTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Wand ID", 1019).getInt();
		
		wandTraining = new ItemTrainingWand(wandTrainingID, EnumRPGWandMaterial.TRAINING, "wandTraining").setCreativeTab(CreativeTabs.tabCombat);
	}
	
	public static void addNames() {
		LanguageRegistry.addName(wandTraining, "Training Wand");
	}
}
