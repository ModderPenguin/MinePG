package rpg.items.knight.weapons;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import rpg.PlayerClassHandler;
import rpg.enums.EnumRPGToolMaterial;
import rpg.items.ItemRPGSword;

public class ItemTrainingSword extends ItemRPGSword {

	public ItemTrainingSword(int par1, EnumRPGToolMaterial par2EnumToolMaterial, String textureFileName) {
		super(par1, par2EnumToolMaterial, textureFileName);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        // Checks the players class and displays a color accordingly
        if(PlayerClassHandler.getPlayersClass() == "Knight") {
            par3List.add("Class: §AKnight");
        } else {
            par3List.add("Class: §4Knight");
        }
    }
}
