package rpg.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import rpg.blocks.tileentity.TileEntityPetEgg;
import rpg.lib.Reference;
import rpg.pet.EnumPetType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPetEgg extends BlockDragonEgg {

    public static int incubationTime;
    
    /** The type of pet that this egg is. */
    public static EnumPetType petType;

    public BlockPetEgg(int par1, String textureFileName, EnumPetType petType) {
        super(par1);
        this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
        this.setUnlocalizedName(textureFileName);
        BlockPetEgg.petType = petType;
        switch(petType) {
        case MAIN:
            BlockPetEgg.incubationTime = 30;
            break;
        default:
            BlockPetEgg.incubationTime = 100;
            break;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + (this.getUnlocalizedName().substring(5)));
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata)
    {
       return new TileEntityPetEgg();
    }

    @Override
    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));

        boolean isFurnaceAbove = par1World.getBlockId(par2, par3 + 1, par4) == Block.furnaceBurning.blockID;
        boolean isFurnaceBelow = par1World.getBlockId(par2, par3 - 1, par4) == Block.furnaceBurning.blockID;

        boolean isFurnaceLeft = par1World.getBlockId(par2 - 1, par3, par4) == Block.furnaceBurning.blockID;
        boolean isFurnaceRight = par1World.getBlockId(par2 + 1, par3, par4) == Block.furnaceBurning.blockID;

        boolean isFurnaceInFront = par1World.getBlockId(par2, par3, par4 + 1) == Block.furnaceBurning.blockID;
        boolean isFurnaceBehind = par1World.getBlockId(par2, par3, par4 - 1) == Block.furnaceBurning.blockID;

        boolean isFurnaceAboveOrBelow = isFurnaceAbove && isFurnaceBelow;
        boolean isFurnaceLeftOrRight = isFurnaceLeft && isFurnaceRight;
        boolean isFurnaceInFrontOrBehind = isFurnaceInFront && isFurnaceBehind;

        boolean furnaceIsNearby = isFurnaceAboveOrBelow && isFurnaceLeftOrRight && isFurnaceInFrontOrBehind;

        if(furnaceIsNearby) {
            TileEntityPetEgg.canIncubate = true;
        }
    }

    @Override
    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    // This is the method to use to see if a furnace has been placed so that the egg can be incubated
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));

        boolean isFurnaceAbove = par1World.getBlockId(par2, par3 + 1, par4) == Block.furnaceBurning.blockID;
        boolean isFurnaceBelow = par1World.getBlockId(par2, par3 - 1, par4) == Block.furnaceBurning.blockID;

        boolean isFurnaceLeft = par1World.getBlockId(par2 - 1, par3, par4) == Block.furnaceBurning.blockID;
        boolean isFurnaceRight = par1World.getBlockId(par2 + 1, par3, par4) == Block.furnaceBurning.blockID;

        boolean isFurnaceInFront = par1World.getBlockId(par2, par3, par4 + 1) == Block.furnaceBurning.blockID;
        boolean isFurnaceBehind = par1World.getBlockId(par2, par3, par4 - 1) == Block.furnaceBurning.blockID;

        boolean isFurnaceAboveOrBelow = isFurnaceAbove && isFurnaceBelow;
        boolean isFurnaceLeftOrRight = isFurnaceLeft && isFurnaceRight;
        boolean isFurnaceInFrontOrBehind = isFurnaceInFront && isFurnaceBehind;

        boolean furnaceIsNearby = isFurnaceAboveOrBelow && isFurnaceLeftOrRight && isFurnaceInFrontOrBehind;

        if(furnaceIsNearby) {
            TileEntityPetEgg.canIncubate = true;
        }
    }

    @Override
    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
        Minecraft.getMinecraft().thePlayer.sendChatToPlayer("[Warning] That is an egg! Be more careful!");
        return true;
    }

    /**
     * How many world ticks before ticking
     */
    @Override
    public int tickRate(World par1World) {
        return 5;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube? This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return true;
    }

    /**
     * The type of render function that is called for this block
     */
    @Override
    public int getRenderType() {
        return 27;
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(World par1World, int par2, int par3, int par4) {
        return 0;
    }
}
