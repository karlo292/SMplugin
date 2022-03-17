package me.karlo292.testplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.Locale;

public class GamemodeCommandSurvival implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(sender instanceof Player p){
            if(p.hasPermission("gamemode.survival")){
                if(args.length == 0){
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(ChatColor.GREEN + "Your gamemode has been changed to survival");


                }else {
                    Player targetPlayer = p.getServer().getPlayer(args[0]);
                    targetPlayer.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(ChatColor.GREEN + "Gamemode of " + args[0] + " has been changed to survival");
                }
                }



            }


        return true;
    }
}
