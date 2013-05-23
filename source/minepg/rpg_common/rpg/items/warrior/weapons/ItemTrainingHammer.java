package rpg.items.warrior.weapons;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import rpg.enums.weapons.EnumRPGHammerMaterial;
import rpg.items.ItemRPGHammer;
import rpg.playerinfo.PlayerInformation;

public class ItemTrainingHammer extends ItemRPGHammer {

    public ItemTrainingHammer(int id, EnumRPGHammerMaterial material,
            int healAmount, String textureFileName) {
        super(id, material, healAmount, textureFileName);
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer player,
            List par3List, boolean par4) {
        PlayerInformation PlayerInfoFake = PlayerInformation.forPlayer(player);
        // Checks the players class and colored item name
        // accordingly
        if ((PlayerInfoFake.getPlayersClass().equals("Paladin") || PlayerInfoFake
                .getPlayersClass().equals("Warrior")) && player.experienceLevel >= 1) {
            par3List.add("Class: ¤APaladin");
            par3List.add("Level: ¤A1");
        } else if ((PlayerInfoFake.getPlayersClass().equals("Paladin") || PlayerInfoFake
                .getPlayersClass().equals("Warrior")) && player.experienceLevel != 1) {
            par3List.add("Class: ¤APaladin");
            par3List.add("Level: ¤41");
        } else if ((!PlayerInfoFake.getPlayersClass().equals("Paladin") || !PlayerInfoFake
                .getPlayersClass().equals("Warrior")) && player.experienceLevel == 1) {
            par3List.add("Class: ¤4Paladin");
            par3List.add("Level: ¤A1");
        } else {
            par3List.add("Class: ¤4Paladin");
            par3List.add("Level: ¤41");
        }
    }
}
