package rpg.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import rpg.PlayerClassHandler;
import rpg.enums.weapons.EnumRPGHammerMaterial;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRPGHammer extends RPGItem {

    private int weaponDamage;
    private final EnumRPGHammerMaterial toolMaterial;
    private final int healAmount;

    public ItemRPGHammer(int id, EnumRPGHammerMaterial material,
            int healAmount, String name) {
        super(id, name);
        this.toolMaterial = material;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.weaponDamage = material.getDamageVsEntity();
        this.healAmount = healAmount;
    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void addInformation(ItemStack par1ItemStack,
            EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        // Checks the players class and colored item name
        // accordingly
        if (PlayerClassHandler.getPlayersClass() == "Warrior") {
            par3List.add("Class: §AWarrior");
            par3List.add("Class: §4Paladin");
            par3List.add("Class: §4Angelic Warrior");
        } else if (PlayerClassHandler.getPlayersClass() == "Paladin") {
            par3List.add("Class: §AWarrior");
            par3List.add("Class: §APaladin");
            par3List.add("Class: §4Angelic Warrior");
        } else if (PlayerClassHandler.getPlayersClass() == "Angel") {
            par3List.add("Class: §AWarrior");
            par3List.add("Class: §APaladin");
            par3List.add("Class: §AAngelic Warrior");
        } else {
            par3List.add("Class: §4Warrior");
            par3List.add("Class: §4Paladin");
            par3List.add("Class: §4Angelic Warrior");
        }
    }

    public int func_82803_g() {
        return this.toolMaterial.getDamageVsEntity();
    }

    /**
     * Returns the damage against a given entity.
     */
    @Override
    public int getDamageVsEntity(Entity par1Entity) {
        return this.weaponDamage;
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    @Override
    public boolean getIsRepairable(ItemStack par1ItemStack,
            ItemStack par2ItemStack) {
        return this.toolMaterial.getHammerCraftingMaterial() == par2ItemStack.itemID ? true
                : super.getIsRepairable(par1ItemStack, par2ItemStack);
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

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    @Override
    public boolean hitEntity(ItemStack par1ItemStack,
            EntityLiving par2EntityLiving, EntityLiving par3EntityLiving) {
        par1ItemStack.damageItem(1, par3EntityLiving);
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D() {
        return true;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
            EntityPlayer par3EntityPlayer) {
        if (PlayerClassHandler.getPlayersClass() == "Paladin"
                || PlayerClassHandler.getPlayersClass() == "Angel") {
            par3EntityPlayer.heal(this.healAmount);
            return par1ItemStack;
        } else
            return null;
    }
}
