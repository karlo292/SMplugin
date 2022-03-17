package me.karlo292.testplugin.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player player = e.getPlayer();
        Block block = e.getBlock();
        if(block.getType() == Material.ACACIA_PLANKS){
            Location location = block.getLocation();
            location = location.add(0,1,0);
            location.getBlock().setType(Material.DIAMOND_BLOCK);
        }
    }
}
