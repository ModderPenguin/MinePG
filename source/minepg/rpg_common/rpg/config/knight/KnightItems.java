package rpg.config.knight;

import net.minecraftforge.common.Configuration;

public class KnightItems {
	
	public static void load(Configuration config) {
		KnightWeapons.load(config);
		KnightArmor.load(config);
	}
	
	public static void addNames() {
		KnightWeapons.addNames();
		KnightArmor.addNames();
	}
}
