package es.zaroz.orecore;

import es.zaroz.orecore.discord.DiscordService;
import es.zaroz.orecore.listeners.playerDeath;
import es.zaroz.orecore.listeners.playerJoin;
import es.zaroz.orecore.mecanicas.TreeCutter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;

public class OreCore extends JavaPlugin {

    private static OreCore instance;

    public static OreCore getInstance() {
        return instance;
    }

    public OreCore() {
        if (instance != null) {
            throw new IllegalStateException("OreCore already initialized!");
        }
        instance = this;
    }

    @Override
    public void onEnable() {
        this.getLogger().log(Level.INFO, "OreCore has been enabled!");

        //check if the data directory exists
        File dataFolder = this.getDataFolder();

        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }

        initializeServices();

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new playerJoin(), (Plugin) this);
        pluginManager.registerEvents(new playerDeath(), (Plugin) this);


        //Mecanicas
        pluginManager.registerEvents(new TreeCutter(), (Plugin) this);

    }

    @Override
    public void onDisable() {
        this.getLogger().log(Level.INFO, "OreCore has been disabled!");
    }

    private void initializeServices() {
        new DiscordService(this).onStart();
    }
}
