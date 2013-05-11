package rpg.items.warrior.weapons;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import rpg.enums.EnumRPGToolMaterial;
import rpg.items.ItemRPGSword;
import rpg.playerinfo.PlayerInformation;

public class ItemTrainingSword extends ItemRPGSword {
    
    public ItemTrainingSword(int id, EnumRPGToolMaterial material, String name) {
        super(id, material, name);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer player, List par3List, boolean par4) {
        PlayerInformation PlayerInfoFake = PlayerInformation.forPlayer(player);
        // Checks the players class and colored item name accordingly
        if(PlayerInfoFake.getPlayersClass() == "Warrior" && player.experienceLevel >= 1) {
            par3List.add("Class: ¤AWarrior");
            par3List.add("Level: ¤A1");
        } else if(PlayerInfoFake.getPlayersClass() == "Warrior" && player.experienceLevel != 1) {
            par3List.add("Class: ¤AWarrior");
            par3List.add("Level: ¤41");
        } else if(PlayerInfoFake.getPlayersClass() != "Warrior" && player.experienceLevel == 1) {
            par3List.add("Class: ¤4Warrior");
            par3List.add("Level: ¤A1");
        } else {
            par3List.add("Class: ¤4Warrior");
            par3List.add("Level: ¤41");
        }
    }
}
