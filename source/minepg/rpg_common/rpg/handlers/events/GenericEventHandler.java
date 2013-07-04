package rpg.handlers.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import rpg.playerinfo.PlayerInformation;
import cpw.mods.fml.common.IPlayerTracker;

public class GenericEventHandler implements IPlayerTracker {

    @ForgeSubscribe
    public void onEntityConstruct(EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityPlayer) {
            event.entity.registerExtendedProperties(PlayerInformation.IDENTIFIER, new PlayerInformation((EntityPlayer) event.entity));
        }
    }

    @ForgeSubscribe
    public void regenerateMana(LivingEvent event) {
        if (event.entity instanceof EntityPlayer) {
            EntityPlayer ent = (EntityPlayer) event.entityLiving;
            PlayerInformation playerInfo = PlayerInformation.forPlayer(ent);
            int mana = playerInfo.getMana();
            int maxmana = playerInfo.getMaxMana();
            if (mana < maxmana) {
                int timer = playerInfo.getManaTimer();
                timer++;
                if (timer >= 40) {
                    playerInfo.increaseMana(10);
                    System.out.println("Mana Timer is: " + timer);
                }
                playerInfo.setManaTimer(timer);
                if (timer == 40) {
                    playerInfo.setManaTimer(0);
                }
            }
        }
    }

    @Override
    public void onPlayerChangedDimension(EntityPlayer player) {
        PlayerInformation.forPlayer(player).setDirty();
    }

    @Override
    public void onPlayerLogin(EntityPlayer player) {
    }

    @Override
    public void onPlayerLogout(EntityPlayer player) {
    }

    @Override
    public void onPlayerRespawn(EntityPlayer player) {
        PlayerInformation.forPlayer(player).setDirty();
    }
}
