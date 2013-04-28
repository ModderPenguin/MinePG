package rpg.config.archer;

import net.minecraftforge.common.Configuration;

public class ArcherItems {
	
	public static void load(Configuration config) {
		ArcherWeapons.load(config);
		ArcherArmor.load(config);
	}
	
	public static void addNames() {
		ArcherWeapons.addNames();
		ArcherArmor.addNames();
	}
}
