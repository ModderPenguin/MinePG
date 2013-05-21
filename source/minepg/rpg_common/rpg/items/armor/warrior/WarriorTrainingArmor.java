package rpg.items.armor.warrior;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
import rpg.config.base.warrior.WarriorArmor;
import rpg.lib.Reference;
import rpg.playerinfo.PlayerInformation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SuppressWarnings("deprecation")
public class WarriorTrainingArmor extends ItemArmor implements
        IArmorTextureProvider {

    public WarriorTrainingArmor(int itemid, EnumArmorMaterial material,
            int par3, int par4, String name) {
        super(itemid, material, par3, par4);
        this.setUnlocalizedName(name);
    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer player,
            List par3List, boolean par4) {
        PlayerInformation PlayerInfoFake = PlayerInformation.forPlayer(player);
        // Checks the players class and colored item name
        // accordingly
        if (PlayerInfoFake.getPlayersClass() == "Warrior"
                && player.experienceLevel >= 1) {
            par3List.add("Class: ¤AWarrior, ¤4Knight,");
            par3List.add("        ¤4Paladin, ¤4Angel");
            par3List.add("Level: ¤A1");
        } else if (PlayerInfoFake.getPlayersClass() == "Knight"
                && player.experienceLevel >= 1) {
            par3List.add("Class: ¤4Warrior, ¤AKnight,");
            par3List.add("        ¤4Paladin, ¤4Angel");
            par3List.add("Level: ¤A1");
        } else if (PlayerInfoFake.getPlayersClass() == "Paladin"
                && player.experienceLevel >= 1) {
            par3List.add("Class: ¤4Warrior, ¤4Knight,");
            par3List.add("        ¤APaladin, ¤4Angel");
            par3List.add("Level: ¤A1");
        } else if (PlayerInfoFake.getPlayersClass() == "Angel"
                && player.experienceLevel >= 1) {
            par3List.add("Class: ¤4Warrior, ¤4Knight,");
            par3List.add("        ¤4Paladin, ¤AAngel");
            par3List.add("Level: ¤A1");
        } else if (PlayerInfoFake.getPlayersClass() == "Warrior"
                && player.experienceLevel != 1) {
            par3List.add("Class: ¤AWarrior, ¤4Knight,");
            par3List.add("        ¤4Paladin, ¤4Angel");
            par3List.add("Level: ¤41");
        } else if (PlayerInfoFake.getPlayersClass() == "Knight"
                && player.experienceLevel != 1) {
            par3List.add("Class: ¤4Warrior, ¤AKnight,");
            par3List.add("        ¤4Paladin, ¤4Angel");
            par3List.add("Level: ¤41");
        } else if (PlayerInfoFake.getPlayersClass() == "Paladin"
                && player.experienceLevel != 1) {
            par3List.add("Class: ¤4Warrior, ¤4Knight,");
            par3List.add("        ¤APaladin, ¤4Angel");
            par3List.add("Level: ¤41");
        } else if (PlayerInfoFake.getPlayersClass() == "Angel"
                && player.experienceLevel != 1) {
            par3List.add("Class: ¤AWarrior, ¤4Knight,");
            par3List.add("        ¤4Paladin, ¤4Angel");
            par3List.add("Level: ¤41");
        } else if ((PlayerInfoFake.getPlayersClass() != "Warrior"
                || PlayerInfoFake.getPlayersClass() != "Knight"
                || PlayerInfoFake.getPlayersClass() != "Paladin" || PlayerInfoFake
                .getPlayersClass() != "Angel") && player.experienceLevel == 1) {
            par3List.add("Class: ¤4Warrior, ¤4Knight,");
            par3List.add("        ¤4Paladin, ¤4Angel");
            par3List.add("Level: ¤A1");
        } else {
            par3List.add("Class: ¤4Warrior, ¤4Knight,");
            par3List.add("        ¤4Paladin, ¤4Angel");
            par3List.add("Level: ¤41");
        }
    }

    @Override
    public String getArmorTextureFile(ItemStack itemstack) {
        if (itemstack.itemID == WarriorArmor.helmetTraining.itemID
                || itemstack.itemID == WarriorArmor.cuirassTraining.itemID
                || itemstack.itemID == WarriorArmor.sabatonsTraining.itemID)
            return "/mods/rpg/textures/armor/warriorTraining_1.png";
        else if (itemstack.itemID == WarriorArmor.greavesTraining.itemID)
            return "/mods/rpg/textures/armor/warriorTraining_2.png";
        else
            return null;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconregister) {
        if(this.itemID == WarriorArmor.helmetTraining.itemID) {
            this.itemIcon = iconregister.registerIcon(Reference.MOD_ID + ":"
                    + this.getUnlocalizedName().substring(5));
        } else if(this.itemID == WarriorArmor.cuirassTraining.itemID) {
            this.itemIcon = iconregister.registerIcon(Reference.MOD_ID + ":"
                    + this.getUnlocalizedName().substring(5));
        } else if(this.itemID == WarriorArmor.greavesTraining.itemID) {
            this.itemIcon = iconregister.registerIcon(Reference.MOD_ID + ":"
                    + this.getUnlocalizedName().substring(5));
        } else if(this.itemID == WarriorArmor.sabatonsTraining.itemID) {
            this.itemIcon = iconregister.registerIcon(Reference.MOD_ID + ":"
                    + this.getUnlocalizedName().substring(5));
        }
    }
}
