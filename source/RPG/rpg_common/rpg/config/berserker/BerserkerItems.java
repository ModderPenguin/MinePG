package rpg.config.berserker;

import net.minecraftforge.common.Configuration;

public class BerserkerItems {
	
	public static void load(Configuration config) {
		BerserkerWeapons.load(config);
		BerserkerArmor.load(config);
	}
	
	public static void addNames() {
		BerserkerWeapons.addNames();
		BerserkerArmor.addNames();
	}
}
