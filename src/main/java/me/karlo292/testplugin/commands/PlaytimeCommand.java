package me.karlo292.testplugin.commands;

import me.karlo292.testplugin.TestPlugin;
import me.karlo292.testplugin.customConfig.customPlayerConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class PlaytimeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p){
            customPlayerConfig.setup();

                int playtimeDays =  customPlayerConfig.get().getInt("playtimeDays");
                int playtimeHours = customPlayerConfig.get().getInt("playtimeHours");
                int playtimeMinutes = customPlayerConfig.get().getInt("playtimeMinutes");
                int playtimeSeconds = customPlayerConfig.get().getInt("playtimeSeconds");
                p.sendMessage(ChatColor.GREEN + "Your playtime is " + playtimeDays + "d, " + playtimeHours + "h, " + playtimeMinutes + "m and " + playtimeSeconds + "s");
                customPlayerConfig.save();
                return true;



            }



        return true;
    }
}
