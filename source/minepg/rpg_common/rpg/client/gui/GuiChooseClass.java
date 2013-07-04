package rpg.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.Item;
import rpg.BaseClassList;
import rpg.gui.ContainerEmpty;
import rpg.network.packet.PacketClassChosen;
import rpg.playerinfo.PlayerInformation;

public class GuiChooseClass extends GuiContainer {

    String[] starterList;
    Item item;

    public GuiChooseClass() {
        super(new ContainerEmpty());
        this.starterList = BaseClassList.getStarterStringList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void initGui() {
        super.initGui();
        this.buttonList.clear();
        for (int i = 0; i < this.starterList.length; i++) {
            this.buttonList.add(new GuiButton(i, this.width / 3 - 100, this.height / 6 + i * 20, this.starterList[i]));
        }
    }

    @Override
    public void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 0:
                new PacketClassChosen("Archer", 0).sendToServer();
                break;
            case 1:
                new PacketClassChosen("Mage", 1).sendToServer();
                break;
            case 2:
                new PacketClassChosen("Warrior", 2).sendToServer();
                break;
        }
        PlayerInformation playerInfo = PlayerInformation.forPlayer(this.mc.thePlayer);

        this.mc.thePlayer.sendChatToPlayer("[MinePG] You have chosen the path of the " + playerInfo.getPlayersClass());
        this.mc.thePlayer.sendChatToPlayer("<Mysterious Voice> Take care in this world my Friend...");
        this.mc.thePlayer.sendChatToPlayer("<Mysterious Voice> Many things lurk here that are better left alone");
        this.mc.thePlayer.sendChatToPlayer("<Mysterious Voice> ...");
        this.mc.thePlayer.sendChatToPlayer("<Mysterious Voice> You will need to be equiped");
        this.mc.thePlayer.sendChatToPlayer("<Mysterious Voice> Have this equipment, learn to use it");
        this.mc.thePlayer.closeScreen();
        // MinecraftForge.EVENT_BUS.register(new
        // HudOverlayHandler());
        System.err.println(this.width);
        System.err.println(this.height);
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float par3, int par1, int par2) {
        this.drawDefaultBackground();
        this.drawString(this.fontRenderer, "Welcome to the world of MinePG!!", 3, 10, 0xFFFFFF);
        this.drawString(this.fontRenderer, "Please pick your desired Class:", 3, 20, 0xFFFFFF);
    }

    @Override
    public void keyTyped(char i, int i1) {
    }
}