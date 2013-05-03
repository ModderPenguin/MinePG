package rpg.config;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import rpg.config.base.archer.ArcherItems;
import rpg.config.base.mage.MageItems;
import rpg.config.base.warrior.WarriorItems;
import rpg.items.materials.ItemTaurite;
import rpg.items.materials.ItemTauriteCloth;
import rpg.items.materials.ItemTrainingCloth;
import rpg.items.materials.ItemTrainingIngot;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RPGItems {
	
	static int trainingIngotID;
	static int trainingClothID;
	static int tauriteID;
	static int tauriteClothID;
	
	public static Item trainingIngot;
	public static Item trainingCloth;
	public static Item taurite;
	public static Item tauriteCloth;
	
	public static void load(Configuration config) {
		ArcherItems.load(config);
		MageItems.load(config);
		WarriorItems.load(config);
		
		trainingIngotID = config.get(Configuration.CATEGORY_ITEM, "Training Ingot ID", 1000).getInt();
		trainingClothID = config.get(Configuration.CATEGORY_ITEM, "Training Cloth ID", 1001).getInt();
		tauriteID = config.get(Configuration.CATEGORY_ITEM, "Taurite ID", 1100).getInt();
		tauriteClothID= config.get(Configuration.CATEGORY_ITEM, "Taurite Cloth ID", 1101).getInt();
		
		trainingIngot = new ItemTrainingIngot(trainingIngotID, "trainingIngot").setCreativeTab(CreativeTabs.tabMaterials);
		trainingCloth = new ItemTrainingCloth(trainingClothID, "trainingCloth").setCreativeTab(CreativeTabs.tabMaterials);
		taurite = new ItemTaurite(tauriteID, "taurite").setCreativeTab(CreativeTabs.tabMaterials);
		tauriteCloth = new ItemTauriteCloth(tauriteClothID, "tauriteCloth").setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	public static void addNames() {
		ArcherItems.addNames();
		MageItems.addNames();
		WarriorItems.addNames();
		
		LanguageRegistry.addName(trainingIngot, "Training Ingot");
		LanguageRegistry.addName(trainingCloth, "Training Cloth");
		LanguageRegistry.addName(taurite, "Taurite");
		LanguageRegistry.addName(tauriteCloth, "Taurite Cloth");
	}
}