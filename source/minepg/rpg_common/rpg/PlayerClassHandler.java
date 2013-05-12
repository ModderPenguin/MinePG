package rpg;

import java.io.File;

import net.minecraft.client.Minecraft;

public class PlayerClassHandler {

    private static String playersClass;
    public static File playerClassFile;

    public static String getPlayersClass() {
        return playersClass;
    }

    public static boolean hasPlayerClassFile() {
        playerClassFile = new File(DownloadHelper.getDir()
                + "/saves/"
                + Minecraft.getMinecraft().theWorld.getSaveHandler()
                        .getWorldDirectoryName() + "Random.txt");
        return playerClassFile.exists();
    }

    public static void setPlayersClass(String string) {
        playersClass = string;
    }
}
