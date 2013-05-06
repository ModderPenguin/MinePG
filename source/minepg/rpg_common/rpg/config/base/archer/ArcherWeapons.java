package rpg.config.base.archer;

import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import rpg.config.RPGCreativeTabs;
import rpg.items.RPGItem;
import rpg.items.archer.weapons.ItemTrainingBow;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ArcherWeapons {

	static int bowTrainingID;
	static int arrowTrainingID;
	
	public static Item bowTraining;
	public static Item arrowTraining;
	
	public static void load(Configuration config) {
		bowTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Bow ID", 1012).getInt();
		arrowTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Arrow ID", 1013).getInt();
		
		bowTraining = new ItemTrainingBow(bowTrainingID, "bowTraining").setCreativeTab(RPGCreativeTabs.tabArcherItems);
		arrowTraining = new RPGItem(arrowTrainingID, "arrowTraining").setCreativeTab(RPGCreativeTabs.tabArcherItems);
	}
	
	public static void addNames() {
		LanguageRegistry.addName(arrowTraining, "Training Arrow");
		LanguageRegistry.addName(bowTraining, "Training Bow");
	}
}
