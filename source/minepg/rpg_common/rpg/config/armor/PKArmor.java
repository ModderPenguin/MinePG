package rpg.config.armor;

import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import rpg.enums.EnumRPGArmorMaterial;
import rpg.items.armor.warrior.PKTrainingArmor;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class PKArmor {
	
	static int helmetTrainingID;
	static int cuirassTrainingID;
	static int greavesTrainingID;
	static int sabatonsTrainingID;
	
	public static Item helmetTraining;
	public static Item cuirassTraining;
	public static Item greavesTraining;
	public static Item sabatonsTraining;
	
	public static void load(Configuration config) {
		helmetTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Helmet ID", 1008).getInt();
		cuirassTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Cuirass ID", 1009).getInt();
		greavesTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Greaves ID", 1010).getInt();
		sabatonsTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Sabatons ID", 1011).getInt();
		
		helmetTraining = new PKTrainingArmor(helmetTrainingID, EnumRPGArmorMaterial.TRAINING, 0, 0, "helmetTraining");
		cuirassTraining = new PKTrainingArmor(cuirassTrainingID, EnumRPGArmorMaterial.TRAINING, 0, 1, "cuirassTraining");
		greavesTraining = new PKTrainingArmor(greavesTrainingID, EnumRPGArmorMaterial.TRAINING, 0, 2, "greavesTraining");
		sabatonsTraining = new PKTrainingArmor(sabatonsTrainingID, EnumRPGArmorMaterial.TRAINING, 0, 3, "sabatonsTraining");
	}
	
	public static void addNames() {
		LanguageRegistry.addName(helmetTraining, "Training Helmet");
		LanguageRegistry.addName(cuirassTraining, "Training Cuirass");
		LanguageRegistry.addName(greavesTraining, "Training Greaves");
		LanguageRegistry.addName(sabatonsTraining, "Training Sabatons");
	}
}
