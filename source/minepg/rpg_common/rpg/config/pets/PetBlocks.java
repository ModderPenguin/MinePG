package rpg.config.pets;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import rpg.blocks.BlockPetEgg;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class PetBlocks {

    static int petEggBlockID;

    public static Block petEggBlockMain;
    public static Block petEggBlockAir;

    public static void load(Configuration config) {
        petEggBlockID = config.get(Configuration.CATEGORY_BLOCK,
                "Pet Egg Block Base ID", 1350).getInt();

        petEggBlockMain = new BlockPetEgg(petEggBlockID, "petEggBlockMain");
        petEggBlockAir = new BlockPetEgg(petEggBlockID + 1, "petEggBlockAir").setCreativeTab(CreativeTabs.tabBlock);
    }

    @SuppressWarnings("deprecation")
    public static void registerBlocks() {
        GameRegistry.registerBlock(petEggBlockMain);
    }

    public static void addNames() {
        LanguageRegistry.addName(petEggBlockMain, "Pet Egg: Main");
    }
}
