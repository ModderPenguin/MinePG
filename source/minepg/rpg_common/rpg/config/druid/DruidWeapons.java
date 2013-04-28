package rpg.config.druid;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import rpg.enums.EnumRPGStaffMaterial;
import rpg.items.druid.weapons.ItemTrainingStaff;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class DruidWeapons {
	
	static int staffTrainingID;
	
	public static Item staffTraining;
	
	public static void load(Configuration config) {
		staffTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Staff ID", 1016).getInt();
		
		staffTraining = new ItemTrainingStaff(staffTrainingID, EnumRPGStaffMaterial.TRAINING, "staffTraining").setCreativeTab(CreativeTabs.tabCombat);
	}
	
	public static void addNames() {
		LanguageRegistry.addName(staffTraining, "Training Staff");
	}
}
