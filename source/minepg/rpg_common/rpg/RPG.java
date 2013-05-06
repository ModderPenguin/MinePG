package rpg;

import java.io.File;
import java.util.logging.Logger;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import rpg.client.HudOverlayHandler;
import rpg.comm.ConnectionHandler;
import rpg.config.RPGConfig;
import rpg.handlers.MinePGPacketHandler;
import rpg.handlers.events.KarmaEventHandler;
import rpg.lib.Reference;
import rpg.sounds.SoundLoader;
import rpg.storage.RPGStorage;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

//@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
//@NetworkMod(tinyPacketHandler = MinePGPacketHandler.class, clientSideRequired = true, serverSideRequired = false)
public class RPG {
	
	@Instance("RPG")
	public static RPG instance;

	@SidedProxy(clientSide = "rpg.client.ClientProxy", serverSide = "rpg.CommonProxy")
	public static CommonProxy proxy;
	
	public static Logger logger = Logger.getLogger("MinePG");
	
	public static File modDirectory;
	
	public static int minodimensionid = 10;
	
    @PreInit
	public void preInit(FMLPreInitializationEvent event) {
		modDirectory = new File(event.getModConfigurationDirectory().getParent());
		if(FMLCommonHandler.instance().getSide().isClient())
		{
			MinecraftForge.EVENT_BUS.register(new SoundLoader());
		}
		RPGConfig.loadConfig(new Configuration(event.getSuggestedConfigurationFile()));	
		
		//MinecraftForge.EVENT_BUS.register(new KarmaEventHandler());
	}

	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		proxy.registerKeyBindings();
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		NetworkRegistry.instance().registerConnectionHandler(new ConnectionHandler());
		MinecraftForge.EVENT_BUS.register(RPGStorage.RandomManager);
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
	}
}
