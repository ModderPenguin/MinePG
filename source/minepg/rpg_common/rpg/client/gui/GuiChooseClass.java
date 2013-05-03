package rpg.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.Item;
import net.minecraft.world.storage.WorldInfo;
import rpg.BaseClassList;
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
				new PacketClassUpdate("Archer").sendToServer();
				mc.thePlayer.sendChatToPlayer("[MinePG] You have chosen the path of the Archer");
		        archerStarterChest.generateChest();
				break;
			case 1:
				new PacketClassUpdate("Mage").sendToServer();
				mc.thePlayer.sendChatToPlayer("[MinePG] You have chosen the path of the Mage");
				break;
			case 2:
				new PacketClassUpdate("Warrior").sendToServer();
				mc.thePlayer.sendChatToPlayer("[MinePG] You have chosen the path of the Warrior");
				break;
		}
		
		mc.thePlayer.sendChatToPlayer("<Mysterious Voice> Take care in this world my Friend...");
		mc.thePlayer.sendChatToPlayer("<Mysterious Voice> Many things lurk here that are better left alone");
		mc.thePlayer.sendChatToPlayer("<Mysterious Voice> ...");
		mc.thePlayer.sendChatToPlayer("<Mysterious Voice> You will need to be equiped");
		mc.thePlayer.sendChatToPlayer("<Mysterious Voice> Have this chest. It contains the items you will need for your journey");
		mc.thePlayer.sendChatToPlayer("[MinePG] ¤AHint: ¤FThe chest should be somewhere near you...");
		mc.thePlayer.closeScreen();
	}

	public void drawGuiContainerBackgroundLayer(float par3, int par1, int par2) {
		drawDefaultBackground();
		drawString(fontRenderer, "Welcome to the world of MinePG!!", 3, 10, 0xFFFFFF);
		drawString(fontRenderer, "Please pick your desired Class:", 3, 20, 0xFFFFFF);
	}
}