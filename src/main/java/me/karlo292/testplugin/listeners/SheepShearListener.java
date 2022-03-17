package me.karlo292.testplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

public class SheepShearListener implements Listener {
    public void onShearSheep(PlayerShearEntityEvent e) {
        Player player = e.getPlayer();
        Entity entity = e.getEntity();

        if (entity.getType() == EntityType.SHEEP) {
            e.setCancelled(true);
            player.sendMessage("You cannot shear sheep!");
        } else {
            player.sendMessage("This is not sheep!");
        }
    }
}
