package rpg.config.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import rpg.blocks.BlockPortalMino;
import rpg.blocks.RPGBlock;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MinotaurBlocks {

    static int tauriteBlockID;
    static int oreTauriteID;
    static int portalMinoID;

    public static Block blockTaurite;
    public static Block oreTaurite;
    public static Block portalMino;

    public static void addNames() {
        LanguageRegistry.addName(blockTaurite, "Block of Taurite");
        LanguageRegistry.addName(oreTaurite, "Taurite Ore");
        LanguageRegistry.addName(portalMino, "Taurite Portal");
    }

    public static void load(Configuration config) {
        tauriteBlockID = config.get(Configuration.CATEGORY_BLOCK, "Taurite Block ID", 1100).getInt();
        oreTauriteID = config.get(Configuration.CATEGORY_BLOCK, "Taurite Ore ID", 1101).getInt();
        portalMinoID = config.get(Configuration.CATEGORY_BLOCK, "Minotaur Portal ID", 1102).getInt();

        blockTaurite = new RPGBlock(tauriteBlockID, Material.rock, "tauriteBlock").setCreativeTab(CreativeTabs.tabBlock);
        oreTaurite = new RPGBlock(oreTauriteID, Material.rock, "tauriteOre").setCreativeTab(CreativeTabs.tabBlock);
        portalMino = new BlockPortalMino(portalMinoID).setUnlocalizedName("minoPortal");
    }

    // @SuppressWarnings("deprecation")
    public static void registerBlocks() {
        // GameRegistry.registerBlock(blockTaurite);
        // GameRegistry.registerBlock(oreTaurite);
        // GameRegistry.registerBlock(portalMino);
    }
}
