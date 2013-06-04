package rpg.handlers.events;

import static rpg.playerinfo.PlayerInformation.forPlayer;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import rpg.MinePGUtil;
import rpg.playerinfo.PlayerInformation;
import rpg.playerinfo.PlayerInformation.CountableKarmaEvent;

import com.google.common.primitives.Ints;

public class KarmaEventHandler {

    private static final int[] bonemealHandleIds = new int[] { Block.sapling.blockID, Block.mushroomBrown.blockID, Block.mushroomRed.blockID, Block.melonStem.blockID, Block.pumpkinStem.blockID,
            Block.cocoaPlant.blockID, Block.grass.blockID };

    private static EntityPlayer playerPlacingBlock;

    private static boolean placingIronGolem; // false =>
                                             // snow golem,
                                             // true => iron
                                             // golem

    // called from ItemBlock.placeBlockAt after the block
    // has successfully been placed
    public static void onAfterBlockSet() {
        if (playerPlacingBlock != null) {
            PlayerInformation info = forPlayer(playerPlacingBlock);

            CountableKarmaEvent event = placingIronGolem ? CountableKarmaEvent.CREATE_IRONGOLEM : CountableKarmaEvent.CREATE_SNOWGOLEM;
            if (info.increaseEventAmount(event)) {
                info.modifyKarma(1);
            }

            playerPlacingBlock = null;
        }
    }

    // called from ItemBlock.placeBlockAt before the world
    // is modified
    public static void onBeforePlayerPlaceBlock(Item item, World world, int x, int y, int z, EntityPlayer player) {
        if (!world.isRemote && item.itemID == Block.pumpkin.blockID) {
            boolean isSnowGolem = world.getBlockId(x, y - 1, z) == Block.blockSnow.blockID && world.getBlockId(x, y - 2, z) == Block.blockSnow.blockID;

            boolean isIronGolem = isSnowGolem ? false
                    : (world.getBlockId(x, y - 1, z) == Block.blockIron.blockID && world.getBlockId(x, y - 2, z) == Block.blockIron.blockID
                            && (world.getBlockId(x - 1, y - 1, z) == Block.blockIron.blockID && world.getBlockId(x + 1, y - 1, z) == Block.blockIron.blockID) || (world.getBlockId(x, y - 1, z - 1) == Block.blockIron.blockID && world
                            .getBlockId(x, y - 1, z + 1) == Block.blockIron.blockID));

            if (isIronGolem || isSnowGolem) {
                playerPlacingBlock = player;
                placingIronGolem = isIronGolem;
            } else {
                playerPlacingBlock = null;
            }
        } else {
            playerPlacingBlock = null;
        }
    }

    public static void onItemPotionUse(ItemStack potion, EntityPlayer player) {
        if (!player.worldObj.isRemote && ItemPotion.isSplash(potion.getItemDamage())) {
            @SuppressWarnings("unchecked")
            List<PotionEffect> effects = Item.potion.getEffects(potion);
            for (PotionEffect effect : effects) {
                if (Potion.heal.id == effect.getPotionID()) {
                    forPlayer(player).modifyKarmaWithMax(1, 30);
                }
            }
        }
    }

    // called by the hook inserted into
    // BlockMobSpawner/removeBlockByPlayer by the
    // CrymodTransformer
    public static void onMobSpawnerBreak(EntityPlayer player, World world, int x, int y, int z) {
        if (!world.isRemote) {
            System.out.println("break mob spawner");
            forPlayer(player).modifyKarmaWithMax(1, 30);
        }
    }

    // set priority to lowest to also give good karma when
    // other mods handle bonemeal event
    // TODO: fixme
    @ForgeSubscribe(priority = EventPriority.LOWEST)
    public void onBonemealUse(BonemealEvent evt) {
        if (evt.getResult() == Result.ALLOW || Ints.contains(bonemealHandleIds, evt.ID) || (evt.ID > 0 && Block.blocksList[evt.ID] instanceof BlockCrops)) {
            forPlayer(evt.entityPlayer).modifyKarmaWithMax(0.1F, 10);
        }
    }

    @ForgeSubscribe
    public void onEntityAttack(LivingAttackEvent evt) {
        if (evt.source instanceof EntityDamageSource && ((EntityDamageSource) evt.source).getEntity() instanceof EntityPlayerMP && evt.entity instanceof EntityPigZombie) {
            PlayerInformation info = forPlayer(((EntityDamageSource) evt.source).getEntity());
            if (info.increaseEventAmount(CountableKarmaEvent.PIGMEN_ATTACK)) {
                info.modifyKarma(-1);
            }
        }
    }

    @ForgeSubscribe
    public void onEntityDeath(LivingDeathEvent evt) {
        if (evt.source.getEntity() instanceof EntityPlayerMP) {
            EntityPlayer player = (EntityPlayer) evt.source.getEntity();

            if (evt.entity instanceof EntityCreeper) {
                forPlayer(player).modifyKarmaWithMax(0.1F, 20);
            } else if (evt.entity instanceof EntityVillager) {
                forPlayer(player).modifyKarmaWithMin(-0.1F, -20);
            } else if (evt.entity instanceof EntityWitch) {
                forPlayer(player).modifyKarmaWithMax(0.5F, 49);
            } else if (evt.entity instanceof EntityIronGolem || evt.entity instanceof EntitySnowman) {
                forPlayer(player).modifyKarmaWithMin(-0.5F, -20);
            } else if (evt.entity instanceof EntityDragon) {
                forPlayer(player).modifyKarma(6);
            }
        }
    }

    @ForgeSubscribe
    public void onEntityInteract(EntityInteractEvent evt) {
        if (evt.entityPlayer instanceof EntityPlayerMP) {
            if (evt.target instanceof EntityAnimal) {
                EntityAnimal animal = (EntityAnimal) evt.target;
                if (animal.isBreedingItem(evt.entityPlayer.getCurrentEquippedItem()) && animal.getGrowingAge() == 0) {
                    MinePGUtil.getEntityData(animal).setString("breedingOwner", evt.entityPlayer.username);
                }
            } else if (evt.target instanceof EntityZombie) {
                EntityZombie zombie = (EntityZombie) evt.target;
                ItemStack currentItem = evt.entityPlayer.getCurrentEquippedItem();
                if (currentItem != null && currentItem.getItem() == Item.appleGold && currentItem.getItemDamage() == 0 && zombie.isVillager() && zombie.isPotionActive(Potion.weakness)) {
                    MinePGUtil.getEntityData(zombie).setString("cureOwner", evt.entityPlayer.username);
                }
            }
        }
    }
}