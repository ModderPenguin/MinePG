package rpg.handlers.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent;
import rpg.playerinfo.PlayerInformation;
import cpw.mods.fml.common.IPlayerTracker;

public class GenericEventHandler implements IPlayerTracker {

    @ForgeSubscribe
    public void onEntityConstruct(EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityPlayer) {
            event.entity.registerExtendedProperties(
                    PlayerInformation.IDENTIFIER, new PlayerInformation(
                            (EntityPlayer) event.entity));
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
