package rpg;

import java.io.File;
import java.util.logging.Logger;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import rpg.client.gui.GuiKarmaBar;
import rpg.client.gui.GuiKarmaBar.GuiRenderKarmaLevel;
import rpg.client.gui.GuiManaBar;
import rpg.comm.ConnectionHandler;
import rpg.config.RPGConfig;
import rpg.config.RPGCreativeTabs;
import rpg.handlers.MinePGPacketHandler;
import rpg.handlers.events.GenericEventHandler;
import rpg.handlers.events.KarmaEventHandler;
import rpg.items.ItemModelRegisters;
import rpg.lib.Reference;
import rpg.sounds.SoundLoader;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(tinyPacketHandler = MinePGPacketHandler.class, clientSideRequired = true, serverSideRequired = false)
public class RPG {

    @Instance("RPG")
    public static RPG instance;

    @SidedProxy(clientSide = "rpg.client.ClientProxy", serverSide = "rpg.CommonProxy")
    public static CommonProxy proxy;

    public static Logger logger = Logger.getLogger("MinePG");

    public static File modDirectory;

    public static int minodimensionid = 10;

    @Init
    public void load(FMLInitializationEvent event) {
        proxy.registerRenderers();
        proxy.registerKeyBindings();

        RPGCreativeTabs.addTabNames();

        ItemModelRegisters.registerItemModelRenderers();

        NetworkRegistry.instance().registerGuiHandler(instance, proxy);
        NetworkRegistry.instance().registerConnectionHandler(new ConnectionHandler());

        KarmaEventHandler karmaHandler = new KarmaEventHandler();
        MinecraftForge.EVENT_BUS.register(karmaHandler);

        GenericEventHandler handler = new GenericEventHandler();
        MinecraftForge.EVENT_BUS.register(handler);
        GameRegistry.registerPlayerTracker(handler);
        
        GuiManaBar manaBar = new GuiManaBar();
        MinecraftForge.EVENT_BUS.register(manaBar);
        
        GuiKarmaBar karmaBar = new GuiKarmaBar();
        MinecraftForge.EVENT_BUS.register(karmaBar);
        
        GuiRenderKarmaLevel karmaLevel = karmaBar.new GuiRenderKarmaLevel();
        MinecraftForge.EVENT_BUS.register(karmaLevel);
    }

    @PostInit
    public void postInit(FMLPostInitializationEvent event) {}

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        modDirectory = new File(event.getModConfigurationDirectory().getParent());
        if (FMLCommonHandler.instance().getSide().isClient()) {
            MinecraftForge.EVENT_BUS.register(new SoundLoader());
        }
        RPGConfig.loadConfig(new Configuration(event.getSuggestedConfigurationFile()));
    }
    
    @ServerStarting
    public void serverStarting(FMLServerStartingEvent evt) {
        
    }
}
