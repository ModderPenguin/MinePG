package rpg.client;

import java.net.URL;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import rpg.lib.Reference;

public class SoundHandler {

    private static final String[] SOUNDS = {
            // obtained from Questology which they obtained
            // from
            // http://www.freesound.org/people/BristolStories/sounds/51713/
            "karmaup",
            // obtained from Questology which they obtained
            // from
            // http://www.freesound.org/people/HerbertBoland/sounds/33637/
            "karmadown",
            // obtained from Questology which they obtained
            // from
            // http://www.freesound.org/people/ryansnook/sounds/108012/
            "karmaerror" };

    private URL getSound(String sound) {
        return getClass().getResource(
                "/mods/" + Reference.MOD_ID + "/resource/sound/" + sound
                        + ".ogg");
    }

    @ForgeSubscribe
    public void onSoundLoad(SoundLoadEvent evt) {
        for (String sound : SOUNDS) {
            evt.manager.soundPoolSounds.addSound("minepgkarma/" + sound
                    + ".ogg", getSound(sound));
        }
    }
}