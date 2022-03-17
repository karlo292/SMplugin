package me.karlo292.testplugin.commands;

import me.karlo292.testplugin.customConfig.customPlayerConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlaytimeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p){
            if(args.length == 0){
                customPlayerConfig.setup();
                int playtimeDays = (int) customPlayerConfig.get().getInt("playtimeDays");
                int playtimeHours = (int) customPlayerConfig.get().getInt("playtimeHours");
                int playtimeMinutes = (int) customPlayerConfig.get().get("playtimeMinutes");
                int playtimeSeconds = (int) customPlayerConfig.get().get("playtimeSeconds");
                p.sendMessage("Your playtime is " + playtimeDays + " days, " + playtimeHours + " hours, " + playtimeMinutes + " minutes and " + playtimeSeconds + " seconds");
                /*p.sendMessage("Days: " + playtimeDays);
                p.sendMessage("Hours: " + playtimeHours);
                p.sendMessage("Minutes: " + playtimeMinutes);
                p.sendMessage("Seconds: " + playtimeSeconds);*/

            }
        }

        return true;
    }
}
