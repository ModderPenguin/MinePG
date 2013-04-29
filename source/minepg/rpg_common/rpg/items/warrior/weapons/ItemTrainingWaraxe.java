package rpg.items.warrior.weapons;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import rpg.enums.weapons.EnumRPGWaraxeMaterial;
import rpg.items.ItemRPGWaraxe;
import rpg.playerinfo.PlayerInformation;

public class ItemTrainingWaraxe extends ItemRPGWaraxe {

	public ItemTrainingWaraxe(int id, EnumRPGWaraxeMaterial material, int duration, int amplifier, String textureFileName) {
		super(id, material, duration, amplifier, textureFileName);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
	    PlayerInformation info = PlayerInformation.forPlayer(par2EntityPlayer);
        // Checks the players class and colored item name accordingly
        if(info.getPlayersClass() == "Berserker") {
            par3List.add("Class: §ABerserker");
        } else {
            par3List.add("Class: §4Berserker");
        }
    }
}