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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer player, List par3List, boolean par4) {
        PlayerInformation PlayerInfoFake = PlayerInformation.forPlayer(player);
        // Checks the players class and colored item name accordingly
        if((PlayerInfoFake.getPlayersClass() == "Berserker" || PlayerInfoFake.getPlayersClass() == "Warrior") && player.experienceLevel >= 1) {
            par3List.add("Class: ¤ABerserker");
            par3List.add("Level: ¤A1");
        } else if((PlayerInfoFake.getPlayersClass() == "Berserker" || PlayerInfoFake.getPlayersClass() == "Warrior") && player.experienceLevel != 1) {
            par3List.add("Class: ¤ABerserker");
            par3List.add("Level: ¤41");
        } else if((PlayerInfoFake.getPlayersClass() != "Berserker" || PlayerInfoFake.getPlayersClass() != "Warrior") && player.experienceLevel == 1) {
            par3List.add("Class: ¤4Berserker");
            par3List.add("Level: ¤A1");
        } else {
            par3List.add("Class: ¤4Berserker");
            par3List.add("Level: ¤41");
        }
    }
}