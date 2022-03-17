package me.karlo292.testplugin.commands;

import me.karlo292.testplugin.TestPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class TeleportCommand implements CommandExecutor {

    private static final Plugin plugin = JavaPlugin.getProvidingPlugin(TestPlugin.class);

    private final HashMap<UUID, Long> cooldown;

    public TeleportCommand() {
        this.cooldown = new HashMap<>();
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {



        if(sender instanceof Player p){
            if(args.length == 0){
                p.sendMessage(ChatColor.RED + "Correct usage: /tpa <player>");
            }
            if(!this.cooldown.containsKey(p.getUniqueId())){
                this.cooldown.put(p.getUniqueId(),System.currentTimeMillis());
                p.sendMessage("Test");
            } else{

                Long timeElapsed = System.currentTimeMillis() - cooldown.get(p.getUniqueId());

                if(timeElapsed >= 10000){
                    p.sendMessage("asd");
                    this.cooldown.put(p.getUniqueId(),System.currentTimeMillis());
                } else{
                    p.sendMessage("Theres " + ((10000 - timeElapsed) / 1000) + " seconds left");
                }
            }

        } else{
            plugin.getLogger().info("This can only be executed as player!");
        }

        return true;
    }
}
