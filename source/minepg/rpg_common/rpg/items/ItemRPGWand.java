package rpg.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import rpg.PlayerClassHandler;
import rpg.client.entities.EntityWandTrainingBolt;
import rpg.enums.weapons.EnumRPGWandMaterial;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRPGWand extends RPGItem {

    private int weaponDamage;
    private final EnumRPGWandMaterial toolMaterial;

    public ItemRPGWand(int id, EnumRPGWandMaterial material, String name) {
        super(id, name);
        this.toolMaterial = material;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.weaponDamage = 4 + material.getDamageVsEntity();
    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void addInformation(ItemStack par1ItemStack,
            EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        // Checks the players class and colored item name
        // accordingly
        if (PlayerClassHandler.getPlayersClass() == "Mage") {
            par3List.add("Class: §AMage");
            par3List.add("Class: §4Sorcerer");
            par3List.add("Class: §4Necromancer");
        } else if (PlayerClassHandler.getPlayersClass() == "Sorcerer") {
            par3List.add("Class: §AMage");
            par3List.add("Class: §ASorcerer");
            par3List.add("Class: §4Necromancer");
        } else if (PlayerClassHandler.getPlayersClass() == "Necromancer") {
            par3List.add("Class: §AMage");
            par3List.add("Class: §ASorcerer");
            par3List.add("Class: §ANecromancer");
        } else {
            par3List.add("Class: §4Mage");
            par3List.add("Class: §4Sorcerer");
            par3List.add("Class: §4Necromancer");
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
        return this.toolMaterial.getWandCraftingMaterial() == par2ItemStack.itemID ? true
                : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }

    /**
     * Return the enchantability factor of the item, most of
     * the time is based on material.
     */
    @Override
    public int getItemEnchantability() {
        return this.toolMaterial.getEnchantability();
    }

    /**
     * returns the action that specifies what animation to
     * play when the items is being used
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
     * Current implementations of this method in child
     * classes do not use the entry argument beside ev. They
     * just raise the damage on the stack.
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

    @Override
    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World,
            int par3, int par4, int par5, int par6,
            EntityLiving par7EntityLiving) {
        if (Block.blocksList[par3]
                .getBlockHardness(par2World, par4, par5, par6) != 0.0D) {
            par1ItemStack.damageItem(2, par7EntityLiving);
        }

        return true;
    }

    /**
     * Called whenever this item is equipped and the right
     * mouse button is pressed. Args: itemStack, world,
     * entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
            EntityPlayer par3EntityPlayer) {
        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F,
                0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if (!par2World.isRemote) {
            par2World.spawnEntityInWorld(new EntityWandTrainingBolt(par2World,
                    par3EntityPlayer));
        }
        return par1ItemStack;
    }
}
