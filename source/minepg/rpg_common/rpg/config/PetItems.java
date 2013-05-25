package rpg.config;

import rpg.items.ItemPetEgg;
import rpg.pets.EnumPetType;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;

public class PetItems {
    
    static int petEggID;
    
    public static Item petEggEarth;
    public static Item petEggFire;
    public static Item petEggLava;
    public static Item petEggMain;
    public static Item petEggNormal;
    public static Item petEggWater;
    public static Item petEggWind;
    
    public static void load(Configuration config) {
        petEggID = config.get(Configuration.CATEGORY_ITEM + Configuration.CATEGORY_SPLITTER, "Base Pet Egg ID", 500).getInt();
        
        petEggMain = new ItemPetEgg(petEggID, "petEggMain", EnumPetType.MAIN).setCreativeTab(RPGCreativeTabs.tabPetItems);
    }
}
