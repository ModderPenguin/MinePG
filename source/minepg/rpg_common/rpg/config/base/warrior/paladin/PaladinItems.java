package rpg.config.base.warrior.paladin;

import net.minecraftforge.common.Configuration;

public class PaladinItems {
	
	public static void load(Configuration config) {
		PaladinWeapons.load(config);
		PaladinArmor.load(config);
	}
	
	public static void addNames() {
		PaladinWeapons.addNames();
		PaladinArmor.addNames();
	}
}
