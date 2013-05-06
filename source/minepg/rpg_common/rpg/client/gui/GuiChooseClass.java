package rpg.client.gui;

import java.util.Random;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.Item;
import net.minecraft.world.storage.WorldInfo;
import rpg.BaseClassList;
import rpg.gui.ContainerEmpty;
import rpg.network.packet.PacketClassUpdate;
import rpg.playerinfo.PlayerInformation;
import rpg.world.gen.WorldGenRandom;
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
        
        Random rand = new Random();
		
        WorldGenRandom randomGen = new WorldGenRandom();
        randomGen.generate(mc.theWorld, rand, x, y, z);
        randomGen.generate2(mc.theWorld, rand, x, y + 1, z);
        randomGen.generate3(mc.theWorld, rand, x, y + 2, z);
        randomGen.generate4(mc.theWorld, rand, x, y + 3, z);
        randomGen.generate5(mc.theWorld, rand, x, y + 4, z);
        randomGen.generate6(mc.theWorld, rand, x, y + 5, z);
        
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