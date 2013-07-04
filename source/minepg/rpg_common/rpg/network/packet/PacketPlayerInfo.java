package rpg.network.packet;

import net.minecraft.entity.player.EntityPlayer;
import rpg.playerinfo.PlayerInformation;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.relauncher.Side;

public class PacketPlayerInfo extends MinePGPacket {

    private String playersClass;
    private float karma;
    private int danris;
    private int mana;
    private int manaTimer;

    public PacketPlayerInfo() {
    }

    @Override
    protected void writeData(ByteArrayDataOutput out) {
        out.writeUTF(this.playersClass);
        out.writeFloat(this.karma);
        out.writeInt(this.danris);
        out.writeInt(this.mana);
        out.writeInt(this.manaTimer);
    }

    @Override
    protected void readData(ByteArrayDataInput in) {
        this.playersClass = in.readUTF();
        this.karma = in.readFloat();
        this.danris = in.readInt();
        this.mana = in.readInt();
        this.manaTimer = in.readInt();
    }

    public PacketPlayerInfo(PlayerInformation playerInformation) {
        this.playersClass = playerInformation.getPlayersClass();
        this.karma = playerInformation.getKarma();
        this.danris = playerInformation.getCurrency();
        this.mana = playerInformation.getMana();
        this.manaTimer = playerInformation.getManaTimer();
    }

    @Override
    protected void execute(EntityPlayer player, Side side) {
        if (side.isClient()) {
            PlayerInformation info = PlayerInformation.forPlayer(player);
            info.setPlayersClass(this.playersClass);
            info.setKarma(this.karma);
            info.setCurrency(this.danris);
            info.setMana(this.mana);
            info.setManaTimer(this.manaTimer);
        }
    }
}