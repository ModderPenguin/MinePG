package rpg.config.blocks;

import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import rpg.blocks.BlockPortalMino;
import rpg.blocks.BlockTauriteBlock;
import rpg.config.RPGBlocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MinotaurBlocks {
	
	static int tauriteBlockID;
	static int tauriteOreID;
	static int minoPortalID;
	
	@Mod.Block(name = "Block of Taurite")
	public static Block blockTaurite;
	@Mod.Block(name = "Taurite Ore")
	public static Block tauriteOre;
	@Mod.Block(name = "Minotaur Portal")
	public static Block minoPortal;
	
	public static void load(Configuration config) {
		tauriteBlockID = config.get(Configuration.CATEGORY_BLOCK, "Taurite Block ID", 250).getInt();
		tauriteOreID = config.get(Configuration.CATEGORY_BLOCK, "Taurite Ore ID", 1101).getInt();
		minoPortalID = config.get(Configuration.CATEGORY_BLOCK, "Minotaur Portal ID", 1102).getInt();
		
		blockTaurite = new BlockTauriteBlock(tauriteBlockID, Material.rock, "tauriteBlock").setCreativeTab(CreativeTabs.tabBlock);
		tauriteOre = new BlockTauriteBlock(tauriteOreID, Material.rock, "tauriteOre").setCreativeTab(CreativeTabs.tabBlock);
		minoPortal = new BlockPortalMino(minoPortalID).setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("minoPortal");
	}
	
	public static void addNames() {
		try {
			for (Field field : RPGBlocks.class.getFields()) {
				if (field.isAnnotationPresent(Mod.Block.class)) {
					Block block = (Block) field.get(null);
					LanguageRegistry.addName(block, field.getAnnotation(Mod.Block.class).name());
				}
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
