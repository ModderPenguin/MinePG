package rpg.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.WorldInfo;
import rpg.BaseClassList;
import rpg.config.armor.BAArmor;
import rpg.config.base.archer.ArcherWeapons;
import rpg.config.base.mage.MageWeapons;
import rpg.gui.ContainerEmpty;
import rpg.network.packet.PacketClassUpdate;
import rpg.playerinfo.PlayerInformation;
import rpg.worldgen.feature.WorldGenArcherStarterChest;

public class GuiChooseClass extends GuiContainer {

	String[] starterList;
	Item item;

	public GuiChooseClass() {
		super(new ContainerEmpty());
		starterList = BaseClassList.getStarterStringList();
	}

	@SuppressWarnings("unchecked")
	public void initGui() {
		super.initGui();
		buttonList.clear();
		for (int i = 0; i < starterList.length; i++) {
			buttonList.add(new GuiButton(i, width / 3 - 100, height / 6 + i * 20, starterList[i]));
		}
	}

	public void keyTyped(char i, int i1) {
	}
	
	public void actionPerformed(GuiButton button) {
	    WorldInfo worldInfo = mc.theWorld.getWorldInfo();
	    int x = worldInfo.getSpawnX();
        int y = worldInfo.getSpawnY();
        int z = worldInfo.getSpawnZ();
        WorldGenArcherStarterChest archerStarterChest = new WorldGenArcherStarterChest(mc.theWorld, x, y, z);
        
        PlayerInformation playerInfo = PlayerInformation.forPlayer(mc.thePlayer);
        
        mc.thePlayer.addExperienceLevel(1);
		
        switch(button.id) {
			case 0:
				PacketClassUpdate archerUpdatePacket = new PacketClassUpdate("Archer");
				archerUpdatePacket.generatePacket();
				archerUpdatePacket.sendToServer();
				mc.thePlayer.sendChatToPlayer("[MinePG] You have chosen the path of the Archer");
				mc.thePlayer.inventory.addItemStackToInventory(new ItemStack(ArcherWeapons.bowTraining, 1));
				mc.thePlayer.inventory.addItemStackToInventory(new ItemStack(ArcherWeapons.arrowTraining, 32));
				mc.thePlayer.inventory.addItemStackToInventory(new ItemStack(BAArmor.tunicTraining, 1));
				mc.thePlayer.inventory.addItemStackToInventory(new ItemStack(BAArmor.legsTraining, 1));
				mc.thePlayer.inventory.addItemStackToInventory(new ItemStack(BAArmor.bootsTraining, 1));
				break;
			case 1:
				PacketClassUpdate mageUpdatePacket = new PacketClassUpdate("Mage");
				mageUpdatePacket.generatePacket();
				mageUpdatePacket.sendToServer();
				mc.thePlayer.sendChatToPlayer("[MinePG] You have chosen the path of the Mage");
				mc.thePlayer.inventory.addItemStackToInventory(new ItemStack(MageWeapons.staffTraining, 1));
				break;
			case 2:
				PacketClassUpdate warriorUpdatePacket = new PacketClassUpdate("Warrior");
				warriorUpdatePacket.generatePacket();
				warriorUpdatePacket.sendToServer();
				mc.thePlayer.sendChatToPlayer("[MinePG] You have chosen the path of the Warrior");
				break;
		}
        
		mc.thePlayer.sendChatToPlayer("<Mysterious Voice> Take care in this world my Friend...");
		mc.thePlayer.sendChatToPlayer("<Mysterious Voice> Many things lurk here that are better left alone");
		mc.thePlayer.sendChatToPlayer("<Mysterious Voice> ...");
		mc.thePlayer.sendChatToPlayer("<Mysterious Voice> You will need to be equiped");
		mc.thePlayer.sendChatToPlayer("<Mysterious Voice> Have this equipment, learn to use it");
		mc.thePlayer.closeScreen();
	}

	public void drawGuiContainerBackgroundLayer(float par3, int par1, int par2) {
		drawDefaultBackground();
		drawString(fontRenderer, "Welcome to the world of MinePG!!", 3, 10, 0xFFFFFF);
		drawString(fontRenderer, "Please pick your desired Class:", 3, 20, 0xFFFFFF);
	}
}