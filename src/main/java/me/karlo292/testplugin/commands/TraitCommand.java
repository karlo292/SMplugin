package me.karlo292.testplugin.commands;

import me.karlo292.testplugin.customConfig.customPlayerConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TraitCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player p){
            if(p.hasPermission("trait.use")) {

                customPlayerConfig.setup();
                if(customPlayerConfig.get().getBoolean("glowstoneTrait") == true){
                    customPlayerConfig.get().set("glowstoneTrait", false);
                } else {
                    customPlayerConfig.get().set("glowstoneTrait", true);
                }
                customPlayerConfig.save();
                customPlayerConfig.reload();
                /*if (args.length == 0) {
                    p.sendMessage(ChatColor.GREEN + "Correct usage: /trait <trait>");
                    return true;
                }
                customPlayerConfig.setup();
                if (args[0] == "glowstone"){
                    customPlayerConfig.get().addDefault("glowstoneTrait", true);
                    customPlayerConfig.save();
                    customPlayerConfig.reload();

                 */





                }

            }


        return true;
    }

}
