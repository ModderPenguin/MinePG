package rpg.items.berserker.weapons;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import rpg.PlayerClassHandler;
import rpg.enums.EnumRPGToolMaterial;
import rpg.items.ItemRPGWaraxe;

public class ItemTrainingWaraxe extends ItemRPGWaraxe {

	public ItemTrainingWaraxe(int id,
			EnumRPGToolMaterial material, String textureFileName) {
		super(id, material, textureFileName);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        // Checks the players class and displays a color accordingly
        if(PlayerClassHandler.getPlayersClass() == "Berserker") {
            par3List.add("Class: §ABerserker");
        } else {
            par3List.add("Class: §4Berserker");
        }
    }
}