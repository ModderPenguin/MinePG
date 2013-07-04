package rpg.handlers.events;

import static rpg.playerinfo.PlayerInformation.forPlayer;
import net.minecraft.block.Block;
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
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import rpg.MinePGUtil;
import rpg.playerinfo.PlayerInformation;
import rpg.playerinfo.PlayerInformation.CountableKarmaEvent;

public class KarmaEventHandler {

    private static EntityPlayer playerPlacingBlock;

    private static boolean placingIronGolem; // false =>
                                             // snow golem,
                                             // true => iron
                                             // golem

    /**
     * Called from ItemBlock.placeBlockAt after the block
     * has successfully been placed
     */
    public static void onAfterBlockSet() {
        if (playerPlacingBlock != null) {
            PlayerInformation info = forPlayer(playerPlacingBlock);

            CountableKarmaEvent event = placingIronGolem ? CountableKarmaEvent.CREATE_IRONGOLEM : CountableKarmaEvent.CREATE_SNOWGOLEM;
            if (info.increaseEventAmount(event)) {
                info.addKarma(50);
            }

            playerPlacingBlock = null;
        }
    }

    // called from ItemBlock.placeBlockAt before the world
    // is modified
    public static void onBeforePlayerPlaceBlock(Item item, World world, int x, int y, int z, EntityPlayer player) {
        if (!world.isRemote && item.itemID == Block.pumpkin.blockID) {
            boolean isSnowGolem = world.getBlockId(x, y - 1, z) == Block.blockSnow.blockID
                    && world.getBlockId(x, y - 2, z) == Block.blockSnow.blockID;

            boolean isIronGolem = isSnowGolem ? false
                    : (world.getBlockId(x, y - 1, z) == Block.blockIron.blockID
                            && world.getBlockId(x, y - 2, z) == Block.blockIron.blockID
                            && (world.getBlockId(x - 1, y - 1, z) == Block.blockIron.blockID && world.getBlockId(x + 1, y - 1, z) == Block.blockIron.blockID) || (world
                            .getBlockId(x, y - 1, z - 1) == Block.blockIron.blockID && world.getBlockId(x, y - 1, z + 1) == Block.blockIron.blockID));

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

    @ForgeSubscribe
    public void onEntityAttack(LivingAttackEvent evt) {
        if (evt.source instanceof EntityDamageSource && ((EntityDamageSource) evt.source).getEntity() instanceof EntityPlayerMP
                && evt.entity instanceof EntityPigZombie) {
            PlayerInformation info = forPlayer(((EntityDamageSource) evt.source).getEntity());
            if (info.increaseEventAmount(CountableKarmaEvent.PIGMEN_ATTACK)) {
                info.addKarma(-10);
            }
        }
    }

    @ForgeSubscribe
    public void onEntityDeath(LivingDeathEvent evt) {
        if (evt.source.getEntity() instanceof EntityPlayerMP) {
            EntityPlayer player = (EntityPlayer) evt.source.getEntity();

            if (evt.entity instanceof EntityCreeper) {
                forPlayer(player).addKarma(10);
            } else if (evt.entity instanceof EntityVillager) {
                forPlayer(player).addKarma(-20);
            } else if (evt.entity instanceof EntityWitch) {
                forPlayer(player).addKarma(75);
            } else if (evt.entity instanceof EntityIronGolem || evt.entity instanceof EntitySnowman) {
                forPlayer(player).addKarma(-50);
            } else if (evt.entity instanceof EntityDragon) {
                forPlayer(player).addKarmaLevel(1);
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
                if (currentItem != null && currentItem.getItem() == Item.appleGold && currentItem.getItemDamage() == 0 && zombie.isVillager()
                        && zombie.isPotionActive(Potion.weakness)) {
                    MinePGUtil.getEntityData(zombie).setString("cureOwner", evt.entityPlayer.username);
                }
            }
        }
    }
}