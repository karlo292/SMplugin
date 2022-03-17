package me.karlo292.testplugin.commands;

import me.karlo292.testplugin.customConfig.customPlayerConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p) {
            if(p.hasPermission("godmode")) {
                if (p.isInvulnerable() == false) {
                    p.setInvulnerable(true);
                    p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "GODMODE ACTIVATED");
                } else {
                    p.setInvulnerable(false);
                    p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "GODMODE DEACTIVATED");

                }
            }


        }
        return true;
    }
}
