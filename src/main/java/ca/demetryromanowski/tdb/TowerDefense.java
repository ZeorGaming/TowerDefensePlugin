package ca.demetryromanowski.tdb;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class TowerDefense extends JavaPlugin implements Listener{
    @Override
    public void onEnable(){
        getLogger().info("Congrats, you have Tower Defense Installed!");

        getServer().getPluginManager().registerEvents(this, this);

        for (Player p : Bukkit.getServer().getOnlinePlayers()){
            getLogger().info("Players: " + p.getName());
        }
    }

    @Override
    public void onDisable(){
        getLogger().info("Y U DISABLE ME :(");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        getLogger().info(event.getPlayer().getDisplayName());
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onPlayerInteractBlock(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Block b = player.getLocation().getBlock();

        if(event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            if (player.getItemInHand().getType() == Material.BLAZE_ROD) {
                b.setType(Material.DISPENSER);
                b.setData((byte) 6);
            }
        }else if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if(player.getItemInHand().getType() == Material.BLAZE_ROD) b.setType(Material.BEACON);

        }else if(event.getAction().equals(Action.RIGHT_CLICK_AIR)){
            player.getWorld().spawnEntity(player.getLocation(), EntityType.ARROW);
        }
    }
}
