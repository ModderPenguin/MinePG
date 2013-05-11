package rpg.items.mage.weapons;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import rpg.enums.weapons.EnumRPGWandMaterial;
import rpg.items.ItemRPGWand;
import rpg.playerinfo.PlayerInformation;

public class ItemTrainingWand extends ItemRPGWand {

	public ItemTrainingWand(int id, EnumRPGWandMaterial material,
			String textureFileName) {
		super(id, material, textureFileName);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer player, List par3List, boolean par4) {
        PlayerInformation PlayerInfoFake = PlayerInformation.forPlayer(player);
        // Checks the players class and colored item name accordingly
        if((PlayerInfoFake.getPlayersClass() == "Sorcerer" || PlayerInfoFake.getPlayersClass() == "Mage") && player.experienceLevel >= 1) {
            par3List.add("Class: ¤ASorcerer");
            par3List.add("Level: ¤A1");
        } else if((PlayerInfoFake.getPlayersClass() == "Sorcerer" || PlayerInfoFake.getPlayersClass() == "Mage") && player.experienceLevel != 1) {
            par3List.add("Class: ¤ASorcerer");
            par3List.add("Level: ¤41");
        } else if((PlayerInfoFake.getPlayersClass() != "Sorcerer" || PlayerInfoFake.getPlayersClass() != "Mage") && player.experienceLevel == 1) {
            par3List.add("Class: ¤4Sorcerer");
            par3List.add("Level: ¤A1");
        } else {
            par3List.add("Class: ¤4Sorcerer");
            par3List.add("Level: ¤41");
        }
    }
}
