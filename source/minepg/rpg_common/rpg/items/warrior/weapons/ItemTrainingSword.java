package rpg.items.warrior.weapons;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import rpg.enums.EnumRPGToolMaterial;
import rpg.items.ItemRPGSword;
import rpg.playerinfo.PlayerInformation;

public class ItemTrainingSword extends ItemRPGSword {
    
    public ItemTrainingSword(int id, EnumRPGToolMaterial material, String name) {
        super(id, material, name);
    }
}
