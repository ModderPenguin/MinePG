package rpg.items.archer.weapons;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import rpg.items.ItemRPGBow;
import rpg.playerinfo.PlayerInformation;

public class ItemTrainingBow extends ItemRPGBow {

    public ItemTrainingBow(int par1, String name) {
        super(par1, name);
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer player,
            List par3List, boolean par4) {
        PlayerInformation PlayerInfoFake = PlayerInformation.forPlayer(player);
        // Checks the players class and colored item name
        // accordingly
        if (PlayerInfoFake.getPlayersClass() == "Archer"
                && player.experienceLevel >= 1) {
            par3List.add("Class: ¤AArcher");
            par3List.add("Level: ¤A1");
        } else if (PlayerInfoFake.getPlayersClass() == "Archer"
                && player.experienceLevel != 1) {
            par3List.add("Class: ¤AArcher");
            par3List.add("Level: ¤41");
        } else if (PlayerInfoFake.getPlayersClass() != "Archer"
                && player.experienceLevel == 1) {
            par3List.add("Class: ¤4Archer");
            par3List.add("Level: ¤A1");
        } else {
            par3List.add("Class: ¤4Archer");
            par3List.add("Level: ¤41");
        }
    }
}
