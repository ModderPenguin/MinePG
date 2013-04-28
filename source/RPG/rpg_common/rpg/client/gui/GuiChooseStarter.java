package rpg.client.gui;

import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.Item;
import net.minecraft.world.storage.WorldInfo;
import rpg.ClassList;
import rpg.IOHelper;
import rpg.PlayerClassHandler;
import rpg.gui.ContainerEmpty;
import rpg.world.gen.feature.WorldGenArcherStarterChest;

public class GuiChooseStarter extends GuiContainer {

	String[] starterList;
	Item item;

	public GuiChooseStarter() {
		super(new ContainerEmpty());
		starterList = ClassList.getStarterStringList();
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
        //WorldGenArcherStarterChest berserkerStarterChest = new WorldGenArcherStarterChest(mc.theWorld, x, y, z);
        //WorldGenBerserkerStarterChest druidStarterChest = new WorldGenBerserkerStarterChest(mc.theWorld, x, y, z);
        //WorldGenDruidStarterChest knightStarterChest = new WorldGenDruidStarterChest(mc.theWorld, x, y, z);
        //WorldGenPaladinStarterChest paladinStarterChest = new WorldGenPaladinStarterChest(mc.theWorld, x, y, z);
        //WorldGenSorcererStarterChest sorcererStarterChest = new WorldGenSorcererStarterChest(mc.theWorld, x, y, z);
        
		switch(button.id) {
			case 0:
				PlayerClassHandler.setPlayerClass("Archer");
				mc.thePlayer.addExperienceLevel(1);
				mc.thePlayer.sendChatToPlayer("[MinePG] You chose the path of the Archer");
				mc.thePlayer.sendChatToPlayer("<Mysterious Voice> Take care in this world my Friend...");
				mc.thePlayer.sendChatToPlayer("<Mysterious Voice> Many things lurk here that are better left alone");
				mc.thePlayer.sendChatToPlayer("<Mysterious Voice> ...");
				mc.thePlayer.sendChatToPlayer("<Mysterious Voice> You will need to be equiped");
				mc.thePlayer.sendChatToPlayer("<Mysterious Voice> Have this chest. It contains the items you will need for your journey");
		        archerStarterChest.generateChest();
				break;
			case 1:
				PlayerClassHandler.setPlayerClass("Berserker");
				mc.thePlayer.addExperienceLevel(1);
				mc.thePlayer.sendChatToPlayer("[MinePG] You chose the path of the Mage");
				mc.thePlayer.sendChatToPlayer("<Mysterious Voice> Take care in this world my Friend...");
				mc.thePlayer.sendChatToPlayer("<Mysterious Voice> Many things lurk here that are better left alone");
				mc.thePlayer.sendChatToPlayer("<Mysterious Voice> ...");
				mc.thePlayer.sendChatToPlayer("<Mysterious Voice> You will need to be equiped");
				mc.thePlayer.sendChatToPlayer("<Mysterious Voice> Have this chest. It contains the items you will need for your journey");
				break;
			case 2:
				PlayerClassHandler.setPlayerClass("Druid");
				mc.thePlayer.addExperienceLevel(1);
				mc.thePlayer.sendChatToPlayer("[MinePG] You chose the path of the Warrior");
				mc.thePlayer.sendChatToPlayer("<Mysterious Voice> Take care in this world my Friend...");
				mc.thePlayer.sendChatToPlayer("<Mysterious Voice> Many things lurk here that are better left alone");
				mc.thePlayer.sendChatToPlayer("<Mysterious Voice> ...");
				mc.thePlayer.sendChatToPlayer("<Mysterious Voice> You will need to be equiped");
				mc.thePlayer.sendChatToPlayer("<Mysterious Voice> Have this chest. It contains the items you will need for your journey");
				break;
		}
		mc.thePlayer.closeScreen();
	}

	public void drawGuiContainerBackgroundLayer(float par3, int par1, int par2) {
		drawDefaultBackground();
		drawString(fontRenderer, "Welcome to the world of MinePG!!", 3, 10, 0xFFFFFF);
		drawString(fontRenderer, "Please pick your desired Class:", 3, 20, 0xFFFFFF);
	}
}