package rpg.items.warrior.weapons;

import rpg.enums.weapons.EnumRPGWaraxeMaterial;
import rpg.items.ItemRPGWaraxe;

public class ItemTrainingWaraxe extends ItemRPGWaraxe {

    public ItemTrainingWaraxe(int id, EnumRPGWaraxeMaterial material,
            int duration, int amplifier, String textureFileName) {
        super(id, material, duration, amplifier, textureFileName);
    }
}