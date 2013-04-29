package rpg.config.armor;

import rpg.enums.EnumRPGArmorMaterial;
import rpg.items.armor.mage.DSTrainingArmor;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class DSArmor {
	
	static int hatTrainingID;
	static int robeTrainingID;
	static int sandalsTrainingID;
	
	public static Item hatTraining;
	public static Item robeTraining;
	public static Item sandalsTraining;
	
	public static void load(Configuration config) {
		hatTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Helm ID", 1005).getInt();
		robeTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Robe ID", 1006).getInt();
		sandalsTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Sandals ID", 1007).getInt();
		
		hatTraining = new DSTrainingArmor(hatTrainingID, EnumRPGArmorMaterial.TRAINING, 0, 0, "hatTraining");
		robeTraining = new DSTrainingArmor(robeTrainingID, EnumRPGArmorMaterial.TRAINING, 0, 1, "robeTraining");
		sandalsTraining = new DSTrainingArmor(sandalsTrainingID, EnumRPGArmorMaterial.TRAINING, 0, 3, "sandalsTraining");
	}
	
	public static void addNames() {
		LanguageRegistry.addName(hatTraining, "Training Hat");
		LanguageRegistry.addName(robeTraining, "Training Robe");
		LanguageRegistry.addName(sandalsTraining, "Training Sandals");
	}
}
