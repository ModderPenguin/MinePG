package rpg.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import rpg.config.base.archer.ArcherWeapons;
import rpg.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRPGBow extends RPGItem {

    String bowpull0 = Reference.MOD_ID + ":"
            + this.getUnlocalizedName().substring(5) + "_pull_0";
    String bowpull1 = Reference.MOD_ID + ":"
            + this.getUnlocalizedName().substring(5) + "_pull_1";
    String bowpull2 = Reference.MOD_ID + ":"
            + this.getUnlocalizedName().substring(5) + "_pull_2";
    public final String[] bowPullIconNameArray = new String[] { bowpull0,
            bowpull1, bowpull2 };
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;

    public ItemRPGBow(int par1, String name) {
        super(par1, name);
        this.maxStackSize = 1;
        this.setMaxDamage(384);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    @SideOnly(Side.CLIENT)
    public Icon func_94599_c(int par1) {
        return this.iconArray[par1];
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    @Override
    public int getItemEnchantability() {
        return 1;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.bow;
    }

    /**
     * How long it takes to use or consume an item
     */
    @Override
    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 72000;
    }

    @Override
    public ItemStack onEaten(ItemStack par1ItemStack, World par2World,
            EntityPlayer par3EntityPlayer) {
        return par1ItemStack;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
            EntityPlayer par3EntityPlayer) {
        // PlayerInformation playerInfo =
        // PlayerInformation.forPlayer(par3EntityPlayer);
        // if(playerInfo.getPlayersClass() == "Archer" ||
        // playerInfo.getPlayersClass() == "Sniper" ||
        // playerInfo.getPlayersClass() == "Assassin" ||
        // playerInfo.getPlayersClass() == "Woodsmen" ||
        // playerInfo.getPlayersClass() == "Hunter") {
        ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer,
                par1ItemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
            return event.result;

        if (par3EntityPlayer.capabilities.isCreativeMode
                || par3EntityPlayer.inventory
                        .hasItem(ArcherWeapons.arrowTraining.itemID)) {
            par3EntityPlayer.setItemInUse(par1ItemStack,
                    this.getMaxItemUseDuration(par1ItemStack));
        }

        return par1ItemStack;
        // } else {
        // return null;
        // }
    }

    /**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
    @Override
    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World,
            EntityPlayer par3EntityPlayer, int par4) {
        int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

        ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer,
                par1ItemStack, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
            return;
        j = event.charge;

        boolean flag = par3EntityPlayer.capabilities.isCreativeMode
                || EnchantmentHelper.getEnchantmentLevel(
                        Enchantment.infinity.effectId, par1ItemStack) > 0;

        if (flag
                || par3EntityPlayer.inventory
                        .hasItem(ArcherWeapons.arrowTraining.itemID)) {
            float f = j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if (f < 0.1D)
                return;

            if (f > 1.0F) {
                f = 1.0F;
            }

            EntityArrow entityarrow = new EntityArrow(par2World,
                    par3EntityPlayer, f * 2.0F);

            if (f == 1.0F) {
                entityarrow.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(
                    Enchantment.power.effectId, par1ItemStack);

            if (k > 0) {
                entityarrow
                        .setDamage(entityarrow.getDamage() + k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(
                    Enchantment.punch.effectId, par1ItemStack);

            if (l > 0) {
                entityarrow.setKnockbackStrength(l);
            }

            if (EnchantmentHelper.getEnchantmentLevel(
                    Enchantment.flame.effectId, par1ItemStack) > 0) {
                entityarrow.setFire(100);
            }

            par1ItemStack.damageItem(1, par3EntityPlayer);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F,
                    1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (flag) {
                entityarrow.canBePickedUp = 2;
            } else {
                par3EntityPlayer.inventory
                        .consumeInventoryItem(ArcherWeapons.arrowTraining.itemID);
            }

            if (!par2World.isRemote) {
                par2World.spawnEntityInWorld(entityarrow);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        super.registerIcons(par1IconRegister);
        this.iconArray = new Icon[bowPullIconNameArray.length];
        for (int i = 0; i < this.iconArray.length; ++i) {
            this.iconArray[i] = par1IconRegister
                    .registerIcon(bowPullIconNameArray[i]);
        }
    }
}
