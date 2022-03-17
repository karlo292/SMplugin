package me.karlo292.testplugin.commands;

import me.karlo292.testplugin.TestPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ReloadConfigCommand implements CommandExecutor {
    private static final Plugin plugin = JavaPlugin.getProvidingPlugin(TestPlugin.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p){
            if(p.hasPermission("reloadconfig")) {
                try {
                    plugin.reloadConfig();
                    p.sendMessage(ChatColor.GREEN + "Reloaded config");
                } catch (Exception e) {
                    p.sendMessage(ChatColor.RED + "ERROR while reloading config, please restart server");
                }
            }
        }

        return true;
    }
}
