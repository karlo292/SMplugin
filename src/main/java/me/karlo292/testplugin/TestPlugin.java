package me.karlo292.testplugin;

import me.karlo292.testplugin.commands.*;
import me.karlo292.testplugin.listeners.*;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;


public final class TestPlugin extends JavaPlugin {

    public static TestPlugin plugin;
    public static Server server;

    @Override
    public void onEnable() {

        plugin = this;

        // Plugin startup logic
        this.getLogger().info("####################");
        this.getLogger().info("Starting SMPlugin");
        this.getLogger().info("Made by karlo292");
        this.getLogger().info("####################");

        getConfig().options().copyDefaults();
        saveDefaultConfig();




        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
        getServer().getPluginManager().registerEvents(new ChatCooldown(),this);


        getCommand("reloadconfig").setExecutor(new ReloadConfigCommand());
        getCommand("godmode").setExecutor(new GodCommand());
        getCommand("hunger").setExecutor(new FeedCommand());
        getCommand("trait").setExecutor(new TraitCommand());
        //getCommand("tpa").setExecutor(new TeleportCommand()); IN DEVELOPMENT
        //getCommand("playtime").setExecutor(new PlaytimeCommand());

        //GAMEMODE
        getCommand("gms").setExecutor(new GamemodeCommandSurvival());
        getCommand("gmc").setExecutor(new GamemodeCommandCreative());
        getCommand("gma").setExecutor(new GamemodeCommandAdventure());
        getCommand("gmsp").setExecutor(new GamemodeCommandSpectator());

    }

}
