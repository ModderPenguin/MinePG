package rpg.blocks.tileentity;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import rpg.blocks.BlockPetEgg;
import rpg.pet.EnumPetType;

public class TileEntityPetEgg extends TileEntity {

	public boolean canIncubate = false;
	public int incubatingTimer = 0;

	public EnumPetType petType;

	public TileEntityPetEgg() {
		this.petType = BlockPetEgg.petType;
	}

	/**
	 * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
	 * ticks and creates a new spawn inside its implementation.
	 */
	public void updateEntity() {
		boolean isFurnaceAbove = this.worldObj.getBlockId(this.xCoord, this.yCoord + 1, this.zCoord) == Block.furnaceBurning.blockID;
		boolean isFurnaceBelow = this.worldObj.getBlockId(this.xCoord, this.yCoord - 1, this.zCoord) == Block.furnaceBurning.blockID;

		boolean isFurnaceLeft = this.worldObj.getBlockId(this.xCoord - 1, this.yCoord, this.zCoord) == Block.furnaceBurning.blockID;
		boolean isFurnaceRight = this.worldObj.getBlockId(this.xCoord + 1, this.yCoord, this.zCoord) == Block.furnaceBurning.blockID;

		boolean isFurnaceInFront = this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord + 1) == Block.furnaceBurning.blockID;
		boolean isFurnaceBehind = this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord - 1) == Block.furnaceBurning.blockID;

		boolean isFurnaceAboveOrBelow = isFurnaceAbove && isFurnaceBelow;
		boolean isFurnaceLeftOrRight = isFurnaceLeft && isFurnaceRight;
		boolean isFurnaceInFrontOrBehind = isFurnaceInFront && isFurnaceBehind;

		boolean furnaceIsNearby = isFurnaceAboveOrBelow && isFurnaceLeftOrRight && isFurnaceInFrontOrBehind;

		if(furnaceIsNearby) {
			this.canIncubate = true;
		}
	}

	public int getIncubationTime() {
		return BlockPetEgg.incubationTime;
	}

	@Override
	public void writeToNBT(NBTTagCompound par1NBTTag) {
		super.writeToNBT(par1NBTTag);
		par1NBTTag.setBoolean("canIncubate", canIncubate);
		par1NBTTag.setInteger("incubatingTimer", incubatingTimer);

	}

	@Override
	public void readFromNBT(NBTTagCompound par1NBTTag) {
		super.readFromNBT(par1NBTTag);
		canIncubate = par1NBTTag.getBoolean("canIncubate");
		incubatingTimer = par1NBTTag.getInteger("incubatingTimer");
	}

	public int getIncubatingTimer() {
		return this.incubatingTimer;
	}
	
	public int setIncubatingTimer(int newTime) {
		if(this.incubatingTimer != newTime)
			this.incubatingTimer = newTime;
		
		return this.incubatingTimer;
	}
}