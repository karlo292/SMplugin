package me.karlo292.testplugin.listeners;

import me.karlo292.testplugin.customConfig.customConfig;
import me.karlo292.testplugin.customConfig.customPlayerConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import me.karlo292.testplugin.TestPlugin;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.util.UUID;


public class JoinLeaveListener implements Listener {


    public static UUID uuid;


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Plugin plugin = TestPlugin.plugin;
        Player player = e.getPlayer();
        uuid = player.getUniqueId();

        e.setJoinMessage(ChatColor.GREEN + player.getDisplayName() + " has joined the server!");
        if(player.hasPlayedBefore()) {
            e.setJoinMessage(ChatColor.GREEN + "Welcome back " + player.getDisplayName());
        } else {
            e.setJoinMessage(ChatColor.GOLD + "Welcome to server " + "" + ChatColor.BOLD + player.getDisplayName() + " have fun!");
        }


        customPlayerConfig.setup();
        customPlayerConfig.get().options().copyDefaults(true);
        customPlayerConfig.get().addDefault("name", player.getName());
        customPlayerConfig.get().addDefault("IP address", player.getAddress().getAddress());
        if(!customPlayerConfig.get().contains("glowstoneTrait")){
            customPlayerConfig.get().addDefault("glowstoneTrait", false);
        }

        //PLAYTIME
        if(!customPlayerConfig.get().contains("playtimeSeconds")){
            customPlayerConfig.get().addDefault("playtimeSeconds", 0);
        }
        if(!customPlayerConfig.get().contains("playtimeMinutes")){
            customPlayerConfig.get().addDefault("playtimeMinutes",0);
        }
        if(!customPlayerConfig.get().contains("playtimeHours")){
            customPlayerConfig.get().addDefault("playtimeHours",0);
        }
        if(!customPlayerConfig.get().contains("playtimeDays")){
            customPlayerConfig.get().addDefault("playtimeDays", 0);
        }
        customPlayerConfig.save();

        new BukkitRunnable() {
            public void run() {
                int seconds = customPlayerConfig.get().getInt("playtimeSeconds") + 1;

                customPlayerConfig.get().set("playtimeSeconds", seconds);

                    if (customPlayerConfig.get().getInt("playtimeSeconds") >= 60) {
                        int minutes = customPlayerConfig.get().getInt("playtimeMinutes") + 1;
                        customPlayerConfig.get().set("playtimeSeconds", 0);
                        customPlayerConfig.get().set("playtimeMinutes", minutes);
                    }
                    if (customPlayerConfig.get().getInt("playtimeMinutes") >= 60) {
                        int hours = customPlayerConfig.get().getInt("playtimeHours") + 1;
                        customPlayerConfig.get().set("playtimeMinutes", 0);
                        customPlayerConfig.get().set("playtimeHours", hours);
                    }
                    if (customPlayerConfig.get().getInt("playtimeHours") >= 24) {
                        int days = customPlayerConfig.get().getInt("playtimeDays") + 1;
                        customPlayerConfig.get().set("playtimeHours", 0);
                        customPlayerConfig.get().set("playtimeDays", days);
                    }
                if(!player.isOnline()){
                    cancel();


                }


                customPlayerConfig.save();
                }

        }.runTaskTimer(plugin, 20L, 20L);





    }


    @EventHandler
    public void onLeave(PlayerQuitEvent e) {

        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.GREEN + player.getDisplayName() + " has left the server!");
        customPlayerConfig.save();

    }

}
