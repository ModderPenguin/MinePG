package rpg.config.base.mage;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import rpg.enums.weapons.EnumRPGStaffMaterial;
import rpg.enums.weapons.EnumRPGWandMaterial;
import rpg.items.mage.weapons.ItemTrainingStaff;
import rpg.items.mage.weapons.ItemTrainingWand;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class MageWeapons {
    
    static int staffTrainingID;
    static int wandTrainingID;
    
    public static Item staffTraining;
    public static Item wandTraining;
    
    public static void load(Configuration config) {
        staffTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Staff ID", 1014).getInt();
        wandTrainingID = config.get(Configuration.CATEGORY_ITEM, "Training Wand ID", 1015).getInt();
        
        staffTraining = new ItemTrainingStaff(staffTrainingID, EnumRPGStaffMaterial.TRAINING, "staffTraining").setCreativeTab(CreativeTabs.tabCombat);
        wandTraining = new ItemTrainingWand(wandTrainingID, EnumRPGWandMaterial.TRAINING, "wandTraining").setCreativeTab(CreativeTabs.tabCombat);
    }

    public static void addNames() {
        LanguageRegistry.addName(staffTraining, "Training Staff");
        LanguageRegistry.addName(wandTraining, "Training Wand");
    }
}
