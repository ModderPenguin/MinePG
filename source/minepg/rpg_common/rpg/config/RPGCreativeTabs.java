package rpg.config;

import net.minecraft.creativetab.CreativeTabs;
import rpg.creativetab.CreativeTabArcherItems;
import rpg.creativetab.CreativeTabMageItems;
import rpg.creativetab.CreativeTabPetItems;
import rpg.creativetab.CreativeTabWarriorItems;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RPGCreativeTabs {

    public static final CreativeTabs tabArcherItems = new CreativeTabArcherItems(
            "archerItems");
    public static final CreativeTabs tabMageItems = new CreativeTabMageItems(
            "mageItems");
    public static final CreativeTabs tabWarriorItems = new CreativeTabWarriorItems(
            "warriorItems");
    public static final CreativeTabs tabPetItems = new CreativeTabPetItems(
            "petItems");

    public static void addTabNames() {
        LanguageRegistry.instance().addStringLocalization(
                "itemGroup.archerItems", "en_US", "Archer Items");
        LanguageRegistry.instance().addStringLocalization(
                "itemGroup.mageItems", "en_US", "Mage Items");
        LanguageRegistry.instance().addStringLocalization(
                "itemGroup.warriorItems", "en_US", "Warrior Items");
        LanguageRegistry.instance().addStringLocalization("itemGroup.petItems",
                "en_US", "Pet Items");
    }
}
