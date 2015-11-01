package ca.demetryromanowski.tdb.core;

import ca.demetryromanowski.tdb.turrets.SpinTurret;
import org.bukkit.event.EventHandler;

import ca.demetryromanowski.tdb.turrets.BasicTurret;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.util.Vector;

import static org.bukkit.block.BlockFace.*;

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
        Player player = event.getPlayer();
        PlayerInventory inventory = player.getInventory();
        ItemStack itemStack = new ItemStack(Material.BLAZE_ROD, 1);
        itemStack.addEnchantment(Enchantment.DAMAGE_ARTHROPODS, 1);

        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("Tower Defense Omni Tool");

        itemStack.setItemMeta(itemMeta);

        inventory.addItem(itemStack);
        player.sendMessage("Use the Omni Tool for things! xD");

    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onPlayerInteractBlock(PlayerInteractEvent event){
        Player player = event.getPlayer();
        //getLogger().info(player.getLocation().getDirection().getX() + " : " + player.getLocation().getDirection().getY() + " : " + player.getLocation().getDirection().getZ());

        //getLogger().info(event.getEventName()
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(event.getBlockFace() != UP) return;
            if (player.getItemInHand().getType() == Material.WOOD) {

                BasicTurret t = new BasicTurret();

                t.addTurret(player.getWorld(), getDirection(player.getLocation().getDirection().normalize()), (int) Math.floor(event.getClickedBlock().getX()),
                        (int) Math.floor(event.getClickedBlock().getY() + 1),
                        (int) Math.floor(event.getClickedBlock().getZ()));
            }
        }
    }

    //TODO(Demetry): Clean this bullshit lol
    protected int getDirection(Vector playerRot){
        int _ret = 1;

        if(playerRot.getX() > 0 && playerRot.getX() > playerRot.getZ())      _ret = 5;
        else if(playerRot.getZ() > 0 && playerRot.getZ() > playerRot.getX()) _ret = 3;

        if(playerRot.getX() < 0 && playerRot.getX() < playerRot.getZ()) _ret = 4;
        else if(playerRot.getZ() < 0 && playerRot.getZ() < playerRot.getX()) _ret = 2;

        return _ret;
    }
}
