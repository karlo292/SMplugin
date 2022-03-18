package me.karlo292.testplugin.listeners;

import me.karlo292.testplugin.TestPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class ChatCooldown implements Listener {
    private static final Plugin plugin = JavaPlugin.getProvidingPlugin(TestPlugin.class);
    private final HashMap<UUID, Long> cooldown;

    public ChatCooldown() {
        this.cooldown = new HashMap<>();
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();


        if(!this.cooldown.containsKey(player.getUniqueId())){
            this.cooldown.put(player.getUniqueId(),System.currentTimeMillis());


        } else{

            long timeElapsed = System.currentTimeMillis() - this.cooldown.get(player.getUniqueId());
            int time = plugin.getConfig().getInt("ChatCooldownTimer") * 1000;
            if(timeElapsed >= time){
                this.cooldown.put(player.getUniqueId(),System.currentTimeMillis());
            } else{
                if(!player.hasPermission("ChatCooldown.bypass")){
                    e.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "Please wait a bit before sending another message");
                }
            }
        }

    }
}
