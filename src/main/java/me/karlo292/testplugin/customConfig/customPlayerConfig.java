package me.karlo292.testplugin.customConfig;

import me.karlo292.testplugin.TestPlugin;
import me.karlo292.testplugin.listeners.JoinLeaveListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class customPlayerConfig {
    private static File file;
    private static FileConfiguration customFile;
    Plugin plugin = TestPlugin.plugin;

    //FINDS OR GENERATES CUSTOM CONFIG FILE
    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("TestPlugin").getDataFolder(), "PlayerDatabase" + File.separator + JoinLeaveListener.uuid.toString());

        if(!file.exists()){
            try {
                file.createNewFile();
            }catch (IOException e){
                //asd
            }
        }
        customFile = YamlConfiguration.loadConfiguration(file);

    }



    public static FileConfiguration get(){
        return customFile;
    }

    public static void save() {
        try {
            customFile.save(file);
        }catch (IOException e){
            System.out.println("ERROR WHILE SAVING CUSTOM CONFIG");
        }
    }

    public static void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }
}
