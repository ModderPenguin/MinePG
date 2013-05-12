package rpg.items.mage.weapons;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import rpg.enums.weapons.EnumRPGStaffMaterial;
import rpg.items.ItemRPGStaff;
import rpg.playerinfo.PlayerInformation;

public class ItemTrainingStaff extends ItemRPGStaff {

    public ItemTrainingStaff(int id, EnumRPGStaffMaterial material,
            String textureFileName) {
        super(id, material, textureFileName);
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer player,
            List par3List, boolean par4) {
        PlayerInformation PlayerInfoFake = PlayerInformation.forPlayer(player);
        // Checks the players class and colored item name
        // accordingly
        if (PlayerInfoFake.getPlayersClass() == "Mage"
                && player.experienceLevel >= 1) {
            par3List.add("Class: ¤AMage");
            par3List.add("Level: ¤A1");
        } else if (PlayerInfoFake.getPlayersClass() == "Mage"
                && player.experienceLevel != 1) {
            par3List.add("Class: ¤AMage");
            par3List.add("Level: ¤41");
        } else if (PlayerInfoFake.getPlayersClass() != "Mage"
                && player.experienceLevel == 1) {
            par3List.add("Class: ¤4Mage");
            par3List.add("Level: ¤A1");
        } else {
            par3List.add("Class: ¤4Mage");
            par3List.add("Level: ¤41");
        }
    }
}
