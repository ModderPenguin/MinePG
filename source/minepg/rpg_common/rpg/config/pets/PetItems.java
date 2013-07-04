package rpg.config.pets;

import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import rpg.config.RPGConfiguration;
import rpg.config.RPGCreativeTabs;
import rpg.items.ItemPetEgg;
import rpg.pet.EnumPetType;

public class PetItems {

    static int petEggID;

    public static Item petEggAir;
    public static Item petEggEarth;
    public static Item petEggFire;
    // public static Item petEggLava;
    public static Item petEggMain;
    public static Item petEggNormal;
    public static Item petEggWater;

    public static void load(Configuration config) {
        petEggID = config.get(RPGConfiguration.CATEGORY_PETS, "Base Pet Egg ID", 500).getInt();

        petEggMain = new ItemPetEgg(petEggID, "petEggMain", EnumPetType.MAIN).setCreativeTab(RPGCreativeTabs.tabPetItems);
        petEggAir = new ItemPetEgg(petEggID + 1, "petEggAir", EnumPetType.AIR).setCreativeTab(RPGCreativeTabs.tabPetItems);
        petEggEarth = new ItemPetEgg(petEggID + 2, "petEggEarth", EnumPetType.EARTH).setCreativeTab(RPGCreativeTabs.tabPetItems);
        petEggFire = new ItemPetEgg(petEggID + 3, "petEggFire", EnumPetType.FIRE).setCreativeTab(RPGCreativeTabs.tabPetItems);
        // petEggLava = new ItemPetEgg(petEggID + 4,
        // "petEggLava",
        // EnumPetType.LAVA).setCreativeTab(RPGCreativeTabs.tabPetItems);
        petEggNormal = new ItemPetEgg(petEggID + 5, "petEggNormal", EnumPetType.NORMAL).setCreativeTab(RPGCreativeTabs.tabPetItems);
        petEggWater = new ItemPetEgg(petEggID + 6, "petEggWater", EnumPetType.WATER).setCreativeTab(RPGCreativeTabs.tabPetItems);
    }
}
