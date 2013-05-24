package rpg.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import rpg.enums.EnumRPGToolMaterial;
import rpg.playerinfo.PlayerInformation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRPGSword extends RPGItem {

    private int weaponDamage;
    private final EnumRPGToolMaterial toolMaterial;

    public ItemRPGSword(int id, EnumRPGToolMaterial material, String name) {
        super(id, name);
        this.toolMaterial = material;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.weaponDamage = 4 + material.getDamageVsEntity();
    }
    
    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer player,
            List par3List, boolean par4) {
        PlayerInformation playerInfo = PlayerInformation.forPlayer(player);
        // Checks the players class and colored item name
        // accordingly
        if (playerInfo.getPlayersClass().equals("Warrior")
                && player.experienceLevel >= 1) {
            par3List.add("Class: \u00a7AWarrior");
            par3List.add("Level: \u00a7A1");
        } else if (playerInfo.getPlayersClass().equals("Warrior")
                && player.experienceLevel != 1) {
            par3List.add("Class: \u00a7AWarrior");
            par3List.add("Level: \u00a741");
        } else if (!playerInfo.getPlayersClass().equals("Warrior")
                && player.experienceLevel == 1) {
            par3List.add("Class: \u00a74Warrior");
            par3List.add("Level: \u00a7A1");
        } else {
            par3List.add("Class: \u00a74Warrior");
            par3List.add("Level: \u00a741");
        }
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    @Override
    public boolean canHarvestBlock(Block par1Block) {
        return par1Block.blockID == Block.web.blockID;
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
        return this.toolMaterial.getToolCraftingMaterial() == par2ItemStack.itemID ? true
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
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    @Override
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
        if (par2Block.blockID == Block.web.blockID)
            return 15.0F;
        else {
            Material material = par2Block.blockMaterial;
            return material != Material.plants && material != Material.vine
                    && material != Material.coral
                    && material != Material.leaves
                    && material != Material.pumpkin ? 1.0F : 1.5F;
        }
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
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
            EntityPlayer par3EntityPlayer) {
        par3EntityPlayer.setItemInUse(par1ItemStack,
                this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
}
