package rpg.client.keybindings;

import java.util.EnumSet;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class PlayerStatsKey extends KeyHandler {
	@SuppressWarnings("rawtypes")
    private EnumSet tickTypes = EnumSet.of(TickType.CLIENT);

    public PlayerStatsKey() {
    	super(new KeyBinding[] { new KeyBinding("PlayerStats Key", Keyboard.KEY_P) }, new boolean[] { false });
    }

    @Override
    public String getLabel() {
    	return "PlayerStats Key";
    }

    @Override
    public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
    }

    @Override
    public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
    	if (/*tickEnd && */FMLClientHandler.instance().getClient().currentScreen == null) {
    		//FMLClientHandler.instance().getClient().displayGuiScreen(new GuiPlayerStats());
    		//World world = FMLClientHandler.instance().getClient().theWorld;
    	}
    }

    @SuppressWarnings("unchecked")
    @Override
    public EnumSet<TickType> ticks() {
    	return tickTypes;
    }
}
