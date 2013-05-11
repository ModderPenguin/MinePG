package rpg.config.base.warrior.paladin;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import rpg.enums.weapons.EnumRPGHammerMaterial;
import rpg.items.warrior.weapons.ItemTrainingHammer;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class PaladinWeapons {
	
	static int hammerTrainingID;
	
	public static Item hammerTraining;
	
	public static void load(Configuration config) {
		hammerTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Staff ID", 1018).getInt();
		
		hammerTraining = new ItemTrainingHammer(hammerTrainingID, EnumRPGHammerMaterial.TRAINING, 1, "hammerTraining").setCreativeTab(CreativeTabs.tabCombat);
	}
	
	public static void addNames() {
		LanguageRegistry.addName(hammerTraining, "Training Hammer");
	}
}
