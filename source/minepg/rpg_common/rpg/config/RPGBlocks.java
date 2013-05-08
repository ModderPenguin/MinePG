package rpg.config;

import net.minecraftforge.common.Configuration;
import rpg.config.blocks.MinotaurBlocks;

public class RPGBlocks {
	
	public static void load(Configuration config) {
		MinotaurBlocks.load(config);
	}
	
	public static void registerBlocks() {
		
	}
	
	public static void addNames() {
		MinotaurBlocks.addNames();
	}
}
