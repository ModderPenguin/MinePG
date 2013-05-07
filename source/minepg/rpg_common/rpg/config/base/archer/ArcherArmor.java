package rpg.config.base.archer;

import cpw.mods.fml.common.registry.LanguageRegistry;
import rpg.enums.EnumRPGArmorMaterial;
import rpg.items.armor.archer.ArcherTrainingArmor;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;

public class ArcherArmor {

	static int tunicTrainingID;
	static int legsTrainingID;
	static int bootsTrainingID;
	
	public static Item tunicTraining;
	public static Item legsTraining;
	public static Item bootsTraining;
	
	public static void load(Configuration config) {
		tunicTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Tunic ID", 1002).getInt();
		legsTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Pants ID", 1003).getInt();
		bootsTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Shoes ID", 1004).getInt();
		
		tunicTraining = new ArcherTrainingArmor(tunicTrainingID, EnumRPGArmorMaterial.TRAINING, 0, 1, "tunicTraining");
		legsTraining = new ArcherTrainingArmor(legsTrainingID, EnumRPGArmorMaterial.TRAINING, 0, 2, "legsTraining");
		bootsTraining = new ArcherTrainingArmor(bootsTrainingID, EnumRPGArmorMaterial.TRAINING, 0, 3, "bootsTraining");
	}
	
	public static void addNames() {
		LanguageRegistry.addName(tunicTraining, "Training Tunic");
		LanguageRegistry.addName(legsTraining, "Training Leggings");
		LanguageRegistry.addName(bootsTraining, "Training Boots");
	}
}
