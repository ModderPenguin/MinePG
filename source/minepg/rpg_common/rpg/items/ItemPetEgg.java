package rpg.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import rpg.config.pets.PetBlocks;
import rpg.config.pets.PetItems;
import rpg.network.packet.PacketDeleteItem;
import rpg.pet.EnumPetType;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemPetEgg extends RPGItem {

    EnumPetType petType;

    public ItemPetEgg(int par1, String name, EnumPetType petType) {
        super(par1, name);
        this.petType = petType;
        LanguageRegistry.addName(this, "Pet Egg: " + this.getUnlocalizedName().substring(11));
    }

    @Override
    @SuppressWarnings({
            "rawtypes", "unchecked"
    })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2par3EntityPlayer, List par3List, boolean par4) {
        switch (this.petType) {
            case AIR:
                par3List.add("Contains an Animal");
                par3List.add("of the Air Element");
                break;
            case EARTH:
                par3List.add("Contains an Animal");
                par3List.add("of the Earth Element");
                break;
            case FIRE:
                par3List.add("Contains an Animal");
                par3List.add("of the Fire Element");
                break;
            /*
             * case LAVA:
             * par3List.add("Contains an Animal");
             * par3List.add("of the Lava Element"); break;
             */
            case NORMAL:
                par3List.add("Contains an Animal");
                par3List.add("of the Normal Element");
                break;
            case WATER:
                par3List.add("Contains an Animal");
                par3List.add("of the Water Element");
                break;
            default:
                par3List.add("Contains an Animal");
                break;
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        float f = 1.0F;
        float f1 = par3EntityPlayer.prevRotationPitch + (par3EntityPlayer.rotationPitch - par3EntityPlayer.prevRotationPitch) * f;
        float f2 = par3EntityPlayer.prevRotationYaw + (par3EntityPlayer.rotationYaw - par3EntityPlayer.prevRotationYaw) * f;
        double d = par3EntityPlayer.prevPosX + (par3EntityPlayer.posX - par3EntityPlayer.prevPosX) * f;
        double d1 = (par3EntityPlayer.prevPosY + (par3EntityPlayer.posY - par3EntityPlayer.prevPosY) * f + 1.6200000000000001D)
                - par3EntityPlayer.yOffset;
        double d2 = par3EntityPlayer.prevPosZ + (par3EntityPlayer.posZ - par3EntityPlayer.prevPosZ) * f;
        Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
        float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
        float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
        float f5 = -MathHelper.cos(-f1 * 0.01745329F);
        float f6 = MathHelper.sin(-f1 * 0.01745329F);
        float f7 = f4 * f5;
        float f8 = f6;
        float f9 = f3 * f5;
        double d3 = 5000D;
        Vec3 vec3d1 = vec3d.addVector(f7 * d3, f8 * d3, f9 * d3);
        MovingObjectPosition movingobjectposition = par2World.rayTraceBlocks_do_do(vec3d, vec3d1, false, true);

        if (movingobjectposition == null)
            return par1ItemStack;

        switch (this.petType) {
            case AIR:
                if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) {
                    int i = movingobjectposition.blockX;
                    int j = movingobjectposition.blockY;
                    int k = movingobjectposition.blockZ;
                    par2World.setBlock(i, j + 1, k, PetBlocks.petEggBlockAir.blockID);
                    if (par3EntityPlayer.inventory.hasItem(PetItems.petEggAir.itemID)) {
                        new PacketDeleteItem(PetItems.petEggAir.itemID).sendToServer();
                    }
                }
                break;
            case EARTH:
                if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) {
                    int i = movingobjectposition.blockX;
                    int j = movingobjectposition.blockY;
                    int k = movingobjectposition.blockZ;
                    par2World.setBlock(i, j + 1, k, PetBlocks.petEggBlockEarth.blockID);
                    if (par3EntityPlayer.inventory.hasItem(PetItems.petEggEarth.itemID)) {
                        new PacketDeleteItem(PetItems.petEggEarth.itemID).sendToServer();
                    }
                }
                break;
            case FIRE:
                if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) {
                    int i = movingobjectposition.blockX;
                    int j = movingobjectposition.blockY;
                    int k = movingobjectposition.blockZ;
                    par2World.setBlock(i, j + 1, k, PetBlocks.petEggBlockFire.blockID);
                    if (par3EntityPlayer.inventory.hasItem(PetItems.petEggFire.itemID)) {
                        new PacketDeleteItem(PetItems.petEggFire.itemID).sendToServer();
                    }
                }
                break;
            /*
             * case LAVA:
             * par3List.add("Contains an Animal");
             * par3List.add("of the Lava Element"); break;
             */
            case NORMAL:
                if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) {
                    int i = movingobjectposition.blockX;
                    int j = movingobjectposition.blockY;
                    int k = movingobjectposition.blockZ;
                    par2World.setBlock(i, j + 1, k, PetBlocks.petEggBlockNormal.blockID);
                    if (par3EntityPlayer.inventory.hasItem(PetItems.petEggNormal.itemID)) {
                        new PacketDeleteItem(PetItems.petEggNormal.itemID).sendToServer();
                    }
                }
                break;
            case WATER:
                if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) {
                    int i = movingobjectposition.blockX;
                    int j = movingobjectposition.blockY;
                    int k = movingobjectposition.blockZ;
                    par2World.setBlock(i, j + 1, k, PetBlocks.petEggBlockWater.blockID);
                    if (par3EntityPlayer.inventory.hasItem(PetItems.petEggWater.itemID)) {
                        new PacketDeleteItem(PetItems.petEggWater.itemID).sendToServer();
                    }
                }
                break;
            default:
                if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) {
                    int i = movingobjectposition.blockX;
                    int j = movingobjectposition.blockY;
                    int k = movingobjectposition.blockZ;
                    par2World.setBlock(i, j + 1, k, PetBlocks.petEggBlockMain.blockID);
                    if (par3EntityPlayer.inventory.hasItem(PetItems.petEggMain.itemID)) {
                        new PacketDeleteItem(PetItems.petEggMain.itemID).sendToServer();
                    }
                }
                break;
        }
        return par1ItemStack;
    }
}
