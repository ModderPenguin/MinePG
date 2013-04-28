package rpg.items.sorcerer.weapons;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import rpg.PlayerClassHandler;
import rpg.enums.EnumRPGWandMaterial;
import rpg.items.ItemRPGWand;

public class ItemTrainingWand extends ItemRPGWand {

	public ItemTrainingWand(int id, EnumRPGWandMaterial material,
			String textureFileName) {
		super(id, material, textureFileName);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        // Checks the players class and displays a color accordingly
        if(PlayerClassHandler.getPlayersClass() == "Sorcerer") {
            par3List.add("Class: §ASorcerer");
        } else {
            par3List.add("Class: §4Sorcerer");
        }
    }
}
