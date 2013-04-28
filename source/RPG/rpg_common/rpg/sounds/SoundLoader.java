package rpg.sounds;

import rpg.RPG;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class SoundLoader {	
	@ForgeSubscribe
	public void loadSounds(SoundLoadEvent event) {
		try
		{
			final String []soundFiles = {
					
			};
			for (int i = 0; i < soundFiles.length; i++){
				event.manager.soundPoolSounds.addSound(soundFiles[i], RPG.class.getResource("/mods/rpg/sounds/" + soundFiles[i]));
			}
		} catch (Exception e) {
			System.err.println("[MinePG] Failed to register one or more sounds.");
		}
	}
}
