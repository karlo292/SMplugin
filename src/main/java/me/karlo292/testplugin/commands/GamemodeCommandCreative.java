package me.karlo292.testplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.Locale;

public class GamemodeCommandCreative implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(sender instanceof Player p){
            if(p.hasPermission("gamemode.creative")){
                if(args.length == 0){
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to creative");


                }else {
                    Player targetPlayer = p.getServer().getPlayer(args[0]);
                    targetPlayer.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(ChatColor.GREEN + "Gamemode of " + args[0] + " has been changed to creative");
                }
            }



        }


        return true;
    }
}