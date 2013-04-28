package rpg.config;

import net.minecraftforge.common.Configuration;

public class RPGConfig {
	
	public static Configuration config;
	
	public static void loadConfig(Configuration configuration) {
		config = configuration;
		config.load();
		RPGBlocks.load(config);
		RPGItems.load(config);
		config.save();
		
		
		RPGItems.addNames();
		RPGBlocks.addNames();
		RPGBlocks.registerBlocks();
	}
}
