package rpg.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import rpg.enums.weapons.EnumRPGWaraxeMaterial;
import rpg.playerinfo.PlayerInformation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRPGWaraxe extends RPGItem {
	private int weaponDamage;
    private final EnumRPGWaraxeMaterial toolMaterial;
    private final int durationOfPotionEffect;
    private final int amplifierOfPotionEffect;
    public ItemRPGWaraxe(int id, EnumRPGWaraxeMaterial material, int duration, int amplifier, String name)
    {
        super(id, name);
        this.toolMaterial = material;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.weaponDamage = 4 + material.getDamageVsEntity();
        this.durationOfPotionEffect = duration;
        this.amplifierOfPotionEffect = amplifier;
    }
    
    public int func_82803_g()
    {
        return this.toolMaterial.getDamageVsEntity();
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving)
    {
        par1ItemStack.damageItem(1, par3EntityLiving);
        return true;
    }

    /**
     * Returns the damage against a given entity.
     */
    public int getDamageVsEntity(Entity par1Entity)
    {
        return this.weaponDamage;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.block;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        PlayerInformation info = PlayerInformation.forPlayer(par3EntityPlayer);
        
        if(info.getPlayersClass() == "Berserker" || info.getPlayersClass() == "Demon") {
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, this.durationOfPotionEffect, this.amplifierOfPotionEffect));
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.resistance.id, this.durationOfPotionEffect, this.amplifierOfPotionEffect));
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, this.durationOfPotionEffect, this.amplifierOfPotionEffect));
            return par1ItemStack;
        } else {
            return null;
        }
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block.blockID == Block.wood.blockID;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this.toolMaterial.getEnchantability();
    }

    /**
     * Return the name for this tool's material.
     */
    public String getToolMaterialName()
    {
        return this.toolMaterial.toString();
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return this.toolMaterial.getWaraxeCraftingMaterial() == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
}
