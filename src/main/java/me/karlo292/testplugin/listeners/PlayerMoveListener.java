package me.karlo292.testplugin.listeners;
import java.sql.*;
import me.karlo292.testplugin.TestPlugin;
import me.karlo292.testplugin.customConfig.customPlayerConfig;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class PlayerMoveListener implements Listener {


    private static Plugin plugin = JavaPlugin.getProvidingPlugin(TestPlugin.class);


    @EventHandler
    public void onMovement(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        World world = player.getWorld();
        Block block = player.getLocation().subtract(0, 1, 0).getBlock();
        Block block1 = player.getLocation().getBlock();
        Location location = player.getLocation();
        Material type = block.getType();
        Material type1 = block1.getType();

        //LIST OF BANNED BLOCKS
        ArrayList<Material> mats = new ArrayList<>();
        ArrayList<Material> mats2 = new ArrayList<>();
        mats.add(Material.WATER);
        mats.add(Material.GLOWSTONE);
        mats.add(Material.LAVA);
        mats.add(Material.AIR);
        mats.add(Material.LILY_PAD);
        mats.add(Material.FARMLAND);
        mats.add(Material.GRASS);
        mats.add(Material.SEAGRASS);
        mats.add(Material.TALL_GRASS);
        mats.add(Material.TALL_SEAGRASS);
        mats.add(Material.OBSIDIAN);
        mats.add(Material.VINE);
        mats.add(Material.CAKE);
        mats.add(Material.CAMPFIRE);

        mats2.add(Material.VINE);
        mats2.add(Material.GRASS);
        mats2.add(Material.LILY_PAD);
        mats2.add(Material.TALL_GRASS);
        mats2.add(Material.TALL_SEAGRASS);
        mats2.add(Material.CARROTS);
        mats2.add(Material.POTATOES);
        mats2.add(Material.WHEAT_SEEDS);
        mats2.add(Material.CAKE);
        mats2.add(Material.CAMPFIRE);
        customPlayerConfig.setup();
        if (customPlayerConfig.get().contains("glowstoneTrait")) {
            if (customPlayerConfig.get().getBoolean("glowstoneTrait") == true) {
                if (!mats.contains(type)) {
                    if (!mats2.contains(type1))
                        block.setType(Material.GLOWSTONE);

                    new BukkitRunnable() {
                        public void run() {
                            block.setType(type);
                        }
                    }.runTaskLater(plugin, 15L);
                }
            }
        }
    }
}