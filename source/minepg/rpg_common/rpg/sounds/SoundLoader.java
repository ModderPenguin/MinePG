package rpg.sounds;

import java.net.URL;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import rpg.lib.Reference;

public class SoundLoader {

    public static boolean didSoundsLoad;

    private static final String[] SOUNDS = {
            "karmaup", "karmadown", "karmaerror"
    };

    private URL getSound(String sound) {
        return this.getClass().getResource("/mods/" + Reference.MOD_ID + "/resource/sound/" + sound + ".ogg");
    }

    @ForgeSubscribe
    public void onSoundLoad(SoundLoadEvent evt) {
        for (String sound : SOUNDS) {
            evt.manager.soundPoolSounds.addSound("minepg/" + sound + ".ogg", this.getSound(sound));
            System.out.println("[MinePG Sound Loader] Loading sounds...");
            SoundLoader.didSoundsLoad = true;
            System.out.println("[MinePG Sound Loader] Sounds Loaded");
        }
    }
}
