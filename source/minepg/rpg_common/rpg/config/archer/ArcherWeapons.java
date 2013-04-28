package rpg.config.archer;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import rpg.items.RPGItem;
import rpg.items.archer.weapons.ItemTrainingBow;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ArcherWeapons {

	static int bowTrainingID;
	static int arrowTrainingID;
	
	public static Item bowTraining;
	public static Item arrowTraining;
	
	public static void load(Configuration config) {
		bowTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Bow ID", 1013).getInt();
		arrowTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Arrow ID", 1014).getInt();
		
		bowTraining = new ItemTrainingBow(bowTrainingID, "bowTraining").setCreativeTab(CreativeTabs.tabCombat);
		arrowTraining = new RPGItem(arrowTrainingID, "arrowTraining").setCreativeTab(CreativeTabs.tabCombat);
	}
	
	public static void addNames() {
		LanguageRegistry.addName(bowTraining, "Training Bow");
		LanguageRegistry.addName(arrowTraining, "Training Arrow");
	}
}
