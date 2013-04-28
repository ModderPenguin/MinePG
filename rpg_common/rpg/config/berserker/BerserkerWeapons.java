package rpg.config.berserker;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import rpg.enums.EnumRPGToolMaterial;
import rpg.items.berserker.weapons.ItemTrainingWaraxe;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BerserkerWeapons {

	static int waraxeTrainingID;
	
	public static Item waraxeTraining;
	
	public static void load(Configuration config) {
		waraxeTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training WarAxe ID", 1015).getInt();
		
		waraxeTraining = new ItemTrainingWaraxe(waraxeTrainingID, EnumRPGToolMaterial.TRAINING, "waraxeTraining").setCreativeTab(CreativeTabs.tabCombat);
	}
	
	public static void addNames() {
		LanguageRegistry.addName(waraxeTraining, "Training Waraxe");
	}
}
