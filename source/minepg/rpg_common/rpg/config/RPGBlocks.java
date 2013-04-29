package rpg.config;

import java.lang.reflect.Field;

import rpg.config.blocks.MinotaurBlocks;

import net.minecraft.block.Block;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RPGBlocks {
	
	
	
	public static void load(Configuration config) {
		MinotaurBlocks.load(config);
	}
	
	public static void registerBlocks() {
		
	}
	
	public static void addNames() {
		MinotaurBlocks.addNames();
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
