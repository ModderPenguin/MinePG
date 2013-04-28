package rpg.items.paladin.weapons;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import rpg.PlayerClassHandler;
import rpg.enums.EnumRPGHammerMaterial;
import rpg.items.ItemRPGHammer;

public class ItemTrainingHammer extends ItemRPGHammer {

	public ItemTrainingHammer(int id, EnumRPGHammerMaterial material,
			String textureFileName) {
		super(id, material, textureFileName);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        // Checks the players class and displays a color accordingly
        if(PlayerClassHandler.getPlayersClass() == "Paladin") {
            par3List.add("Class: §APaladin");
        } else {
            par3List.add("Class: §4Paladin");
        }
    }
}
