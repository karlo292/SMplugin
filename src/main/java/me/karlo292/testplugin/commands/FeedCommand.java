package me.karlo292.testplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p) {
            if(args.length > 0) {
                if (p.hasPermission("TestPlugin.feed")) {

                    Player targetPlayer = p.getServer().getPlayer(args[0]);
                    if(targetPlayer != null){
                        targetPlayer.setFoodLevel(20);
                        p.sendMessage(ChatColor.GREEN +  "Hunger bar of " + args[0] + " is full now"  );
                    } else{
                        p.sendMessage(ChatColor.RED + args[0] + " is not online right now");
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "You do not have permission to do that!");
                }

            }else {
                if (p.hasPermission("TestPlugin.feed")) {
                    p.setFoodLevel(20);
                    p.sendMessage(ChatColor.GREEN + "Your hunger bar is full now");
                } else {
                    p.sendMessage(ChatColor.RED + "You do not have permission to do that!");
                }
            }



        }

        return true;

    }

}
