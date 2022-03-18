package me.karlo292.testplugin.commands;

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
            if(args.length == 0){
                customPlayerConfig.setup();
                int playtimeDays =  (int) customPlayerConfig.get().getInt("playtimeDays");
                int playtimeHours = (int) customPlayerConfig.get().getInt("playtimeHours");
                int playtimeMinutes = (int) customPlayerConfig.get().getInt("playtimeMinutes");
                int playtimeSeconds = (int) customPlayerConfig.get().getInt("playtimeSeconds");
                p.sendMessage(ChatColor.GREEN + "Your playtime is " + playtimeDays + "d, " + playtimeHours + "h, " + playtimeMinutes + "m and " + playtimeSeconds + "s");
                return true;

            }else{
                if(Bukkit.getPlayer(args[0]) == null){
                    p.sendMessage(ChatColor.RED + "That player never played on server before");
                    return true;
                }
                UUID targetPlayerUUID = Bukkit.getServer().getPlayer(args[0]).getUniqueId();
                File file = new File(Bukkit.getServer().getPluginManager().getPlugin("TestPlugin").getDataFolder(), "PlayerDatabase" + File.separator + targetPlayerUUID.toString());

                if(!file.exists()){
                    p.sendMessage(ChatColor.RED + "That player never played on server before");
                    return true;
                }
                FileConfiguration customFile = YamlConfiguration.loadConfiguration(file);
                int playtimeDays =  (int) customFile.getInt("playtimeDays");
                int playtimeHours = (int) customFile.getInt("playtimeHours");
                int playtimeMinutes = (int) customFile.getInt("playtimeMinutes");
                int playtimeSeconds = (int) customFile.getInt("playtimeSeconds");
                p.sendMessage(ChatColor.GREEN + "Playtime of " + args[0] + " is " + playtimeDays + "d, " + playtimeHours + "h, " + playtimeMinutes + "m and " + playtimeSeconds + "s");
            }
        }

        return true;
    }
}
