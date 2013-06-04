package rpg.network.packet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import rpg.config.base.archer.ArcherArmor;
import rpg.config.base.archer.ArcherWeapons;
import rpg.config.base.mage.MageArmor;
import rpg.config.base.mage.MageWeapons;
import rpg.config.base.warrior.WarriorArmor;
import rpg.config.base.warrior.WarriorWeapons;
import rpg.playerinfo.PlayerInformation;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.relauncher.Side;

public class PacketClassChosen extends MinePGPacket {

    String playersNewClass;
    int buttonID;

    public PacketClassChosen() {
    }

    public PacketClassChosen(String playersNewClass, int buttonID) {
        this.playersNewClass = playersNewClass;
        this.buttonID = buttonID;
    }

    @Override
    protected void execute(EntityPlayer player, Side side) {
        if (side.isServer()) {
            PlayerInformation playerInfo = PlayerInformation.forPlayer(player);
            playerInfo.setCurrency(20);
            player.addExperienceLevel(1);
            switch (this.buttonID) {
            case 0:
                playerInfo.setPlayersClass(this.playersNewClass);
                player.inventory.addItemStackToInventory(new ItemStack(ArcherWeapons.bowTraining, 1));
                player.inventory.addItemStackToInventory(new ItemStack(ArcherWeapons.arrowTraining, 32));
                player.inventory.addItemStackToInventory(new ItemStack(ArcherArmor.tunicTraining, 1));
                player.inventory.addItemStackToInventory(new ItemStack(ArcherArmor.legsTraining, 1));
                player.inventory.addItemStackToInventory(new ItemStack(ArcherArmor.bootsTraining, 1));
                new PacketPlayerInfo(playerInfo).sendToPlayer(player);
                break;
            case 1:
                playerInfo.setPlayersClass(this.playersNewClass);
                player.inventory.addItemStackToInventory(new ItemStack(MageWeapons.staffTraining, 1));
                player.inventory.addItemStackToInventory(new ItemStack(MageArmor.hatTraining, 1));
                player.inventory.addItemStackToInventory(new ItemStack(MageArmor.robeTraining, 1));
                player.inventory.addItemStackToInventory(new ItemStack(MageArmor.sandalsTraining, 1));
                new PacketPlayerInfo(playerInfo).sendToPlayer(player);
                break;
            case 2:
                playerInfo.setPlayersClass(this.playersNewClass);
                player.inventory.addItemStackToInventory(new ItemStack(WarriorWeapons.swordTraining, 1));
                player.inventory.addItemStackToInventory(new ItemStack(WarriorArmor.helmetTraining, 1));
                player.inventory.addItemStackToInventory(new ItemStack(WarriorArmor.cuirassTraining, 1));
                player.inventory.addItemStackToInventory(new ItemStack(WarriorArmor.greavesTraining, 1));
                player.inventory.addItemStackToInventory(new ItemStack(WarriorArmor.sabatonsTraining, 1));
                new PacketPlayerInfo(playerInfo).sendToPlayer(player);
                break;
            }
        }
    }

    @Override
    protected void writeData(ByteArrayDataOutput out) {
        out.writeUTF(this.playersNewClass);
        out.writeInt(buttonID);
    }

    @Override
    protected void readData(ByteArrayDataInput in) {
        this.playersNewClass = in.readUTF();
        this.buttonID = in.readInt();
    }

}
