package rpg.items.mage.weapons;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import rpg.client.entities.projectiles.EntityStaffTrainingBolt;
import rpg.enums.weapons.EnumRPGStaffMaterial;
import rpg.items.RPGItem;
import rpg.network.packet.PacketPlayerInfo;
import rpg.network.packet.PacketSendChat;
import rpg.playerinfo.PlayerInformation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRPGStaff extends RPGItem {

    private final EnumRPGStaffMaterial toolMaterial;

    public ItemRPGStaff(int id, EnumRPGStaffMaterial material, String name) {
        super(id, name);
        this.toolMaterial = material;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        PlayerInformation playerInfo = PlayerInformation.forPlayer(par3EntityPlayer);
        if (playerInfo.getPlayersClass().equals("Mage")) {
            if (playerInfo.getMana() >= 5) {
                if (!par3EntityPlayer.capabilities.isCreativeMode) {
                    playerInfo.decreaseMana(1);
                    new PacketPlayerInfo(playerInfo).sendToServer();
                }

                par2World.playSoundAtEntity(par3EntityPlayer, /*
                                                               * There is no sound here for now... I need to find a
                                                               * suitable one
                                                               */
                        "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

                if (!par2World.isRemote) {
                    par2World.spawnEntityInWorld(new EntityStaffTrainingBolt(par2World, par3EntityPlayer));
                }
                par1ItemStack.damageItem(2, par3EntityPlayer);
            } else {
                Minecraft.getMinecraft().thePlayer.sendChatToPlayer("\u00a74Insufficient Mana!");
            }
        } else {
            if (playerInfo.getShouldUseMysteriousVoice()) {
                new PacketSendChat("\u00a74<Mysterious Voice> Do not try to use the power of a weapon that is not meant for you!").sendToServer();
            } else {
                new PacketSendChat("\u00a74<Dagon> Do not try to use the power of a weapon that is not meant for you!").sendToServer();
            }
        }

        return par1ItemStack;
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer player, List par3List, boolean par4) {
        PlayerInformation PlayerInfoFake = PlayerInformation.forPlayer(player);
        // Checks the players class and colored item name
        // accordingly
        if (PlayerInfoFake.getPlayersClass().equals("Mage") && player.experienceLevel >= 1) {
            par3List.add("Class: \u00a7AMage");
            par3List.add("Level: \u00a7A1");
        } else if (PlayerInfoFake.getPlayersClass().equals("Mage") && player.experienceLevel != 1) {
            par3List.add("Class: \u00a7AMage");
            par3List.add("Level: \u00a741");
        } else if (!PlayerInfoFake.getPlayersClass().equals("Mage") && player.experienceLevel == 1) {
            par3List.add("Class: \u00a74Mage");
            par3List.add("Level: \u00a7A1");
        } else {
            par3List.add("Class: \u00a74Mage");
            par3List.add("Level: \u00a741");
        }
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    @Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
        return this.toolMaterial.getStaffCraftingMaterial() == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    @Override
    public int getItemEnchantability() {
        return this.toolMaterial.getEnchantability();
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.block;
    }

    /**
     * How long it takes to use or consume an item
     */
    @Override
    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 72000;
    }

    /**
     * Return the name for this tool's material.
     */
    public String getToolMaterialName() {
        return this.toolMaterial.toString();
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D() {
        return true;
    }
}
