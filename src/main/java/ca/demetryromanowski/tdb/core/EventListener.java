package ca.demetryromanowski.tdb.core;

import ca.demetryromanowski.tdb.turrets.AimedTurret;
import ca.demetryromanowski.tdb.turrets.BasicTurret;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.util.Vector;

import static org.bukkit.block.BlockFace.UP;

public class EventListener implements Listener{
    private ItemStack itemStack;

    public EventListener(ItemStack itemStack){
        this.itemStack = itemStack;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        PlayerInventory inventory = player.getInventory();

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
            if(player.getItemInHand() == itemStack){
                AimedTurret t = new AimedTurret();
                t.addTurret(player.getWorld(), getDirection(player.getLocation().getDirection().normalize()), (int) Math.floor(event.getClickedBlock().getX()),
                        (int) Math.floor(event.getClickedBlock().getY() + 1),
                        (int) Math.floor(event.getClickedBlock().getZ()));
            }

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

        if(playerRot.getX() > 0 && playerRot.getX() > playerRot.getZ() - 0.4f)      _ret = 5;
        else if(playerRot.getZ() > 0 && playerRot.getZ() > playerRot.getX() - 0.4f) _ret = 3;

        if(playerRot.getX() < 0 && playerRot.getX() < playerRot.getZ() + 0.4f) _ret = 4;
        else if(playerRot.getZ() < 0 && playerRot.getZ() < playerRot.getX() + 0.4f) _ret = 2;

        return _ret;
    }
}
