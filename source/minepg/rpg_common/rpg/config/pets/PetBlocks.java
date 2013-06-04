package rpg.config.pets;

import net.minecraft.block.Block;
import net.minecraftforge.common.Configuration;
import rpg.blocks.BlockPetEgg;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class PetBlocks {

    static int petEggBlockID;

    public static Block petEggBlockMain;
    public static Block petEggBlockAir;
    public static Block petEggBlockEarth;
    public static Block petEggBlockFire;
    public static Block petEggBlockNormal;
    public static Block petEggBlockWater;

    public static void load(Configuration config) {
        petEggBlockID = config.get(Configuration.CATEGORY_BLOCK, "Pet Egg Block Base ID", 1350).getInt();

        petEggBlockMain = new BlockPetEgg(petEggBlockID, "petEggBlockMain");
        petEggBlockAir = new BlockPetEgg(petEggBlockID + 1, "petEggBlockAir");
        petEggBlockEarth = new BlockPetEgg(petEggBlockID + 2, "petEggBlockEarth");
        petEggBlockFire = new BlockPetEgg(petEggBlockID + 3, "petEggBlockFire");
        petEggBlockNormal = new BlockPetEgg(petEggBlockID + 4, "petEggBlockNormal");
        petEggBlockWater = new BlockPetEgg(petEggBlockID + 5, "petEggBlockWater");
    }

    @SuppressWarnings("deprecation")
    public static void registerBlocks() {
        GameRegistry.registerBlock(petEggBlockMain);
    }

    public static void addNames() {
        LanguageRegistry.addName(petEggBlockMain, "Pet Egg: Main");
    }
}
