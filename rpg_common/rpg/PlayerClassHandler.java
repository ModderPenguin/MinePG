package rpg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.Player;

public class PlayerClassHandler {
	private static String playerClass;
	    
	public static File playersClass;
	
	public static void setPlayerClass(String chosenClass) {
		playerClass = chosenClass;
	}
	
	public static String getPlayersClass() {
	        return playerClass;
	}
	
	private static String readFile(String file) throws IOException {
	    @SuppressWarnings("resource")
        BufferedReader reader = new BufferedReader( new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    while( ( line = reader.readLine() ) != null ) {
	        stringBuilder.append( line );
	        stringBuilder.append( ls );
	    }

	    return stringBuilder.toString();
	}
	
	public static String getStringFromFile(Player player) throws IOException {
	    String className = readFile(DownloadHelper.getDir() + "/saves/" + ((EntityPlayerMP) player).worldObj.getSaveHandler().getWorldDirectoryName() + "/players/" + "Class.txt");
	    setPlayerClass(className);
	    return className;
	}
	
	public static boolean hasPlayerClass(Player player) {
	    // + ((EntityPlayerMP) player).username
		playersClass = new File(DownloadHelper.getDir() + "/saves/" + ((EntityPlayerMP) player).worldObj.getSaveHandler().getWorldDirectoryName() + "/players/" + "Class.txt");
		return playersClass.exists();
	}
}
