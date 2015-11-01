package ca.demetryromanowski.tdb;

import ca.demetryromanowski.tdb.turrets.AimedTurret;
import ca.demetryromanowski.tdb.turrets.BasicTurret;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;

import org.bukkit.Bukkit;
import org.bukkit.Material;
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

        Location ploc = player.getLocation();
        Location bloc = ploc.toVector().add(ploc.getDirection().normalize()).toLocation(ploc.getWorld());


        //getLogger().info(event.getEventName()
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(event.getBlockFace() != BlockFace.UP) return;
            if (player.getItemInHand().getType() == Material.WOOD) {
                BlockFace face = ploc.getWorld().getBlockAt(ploc).getFace(ploc.getWorld().getBlockAt(bloc));
                BasicTurret t = new BasicTurret();
                AimedTurret t1 = new AimedTurret();

                t.addTurret(player.getWorld(), 0, (int) Math.floor(event.getClickedBlock().getX()),
                        (int) Math.floor(event.getClickedBlock().getY() + 1),
                        (int) Math.floor(event.getClickedBlock().getZ()));

                t1.addTurret(player.getWorld(), 0, (int) Math.floor(event.getClickedBlock().getX()),
                        (int) Math.floor(event.getClickedBlock().getY() + 1),
                        (int) Math.floor(event.getClickedBlock().getZ() + 1));

            }
        }
    }
}
