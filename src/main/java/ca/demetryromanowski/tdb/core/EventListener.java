package ca.demetryromanowski.tdb.core;

import org.bukkit.event.EventHandler;

import ca.demetryromanowski.tdb.turrets.Turret;
import ca.demetryromanowski.tdb.tools.OmniTool;
import ca.demetryromanowski.tdb.blocks.SpawnBlocks;
import ca.demetryromanowski.tdb.inventory.Shop;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;

import static org.bukkit.block.BlockFace.UP;

public class EventListener implements Listener{
    //TODO(Demetry): Clean up variables
    private TowerDefense towerDefense;
    private OmniTool omniTool = new OmniTool();
    private ArrayList<Turret> turrets = new ArrayList<>();
    private Shop shop;

    public EventListener(TowerDefense towerDefense){
        this.towerDefense = towerDefense;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        reset(event.getPlayer());
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onInventoryClick(InventoryClickEvent event){
        try {
            if (event.getCurrentItem() == null) return;
            if (event.isCancelled()) return;
            if (event.getInventory().equals(shop.getShop())) {
                //do something
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.sendMessage("Cunts");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteractBlock(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(event.getBlockFace() != UP) return;
            for(SpawnBlocks block : SpawnBlocks.values()) {
                if (player.getItemInHand().equals(block.getItem())) {
                    turrets.add(
                        block.getTurret().addTurret(
                            player.getWorld(),
                            getDirection(player.getLocation().getYaw()),
                            (int) Math.floor(event.getClickedBlock().getX()),
                            (int) Math.floor(event.getClickedBlock().getY() + 1),
                            (int) Math.floor(event.getClickedBlock().getZ())
                        )
                    );
                    player.getInventory().setItemInHand(null);
                }
            }
            //remove the turret
        }else if(event.getAction().equals(Action.LEFT_CLICK_BLOCK)){
            if(player.getItemInHand().equals(omniTool.getTool())) {
                for (Turret t : turrets) {
                    if (event.getClickedBlock().equals(t.getBotBlock()) || event.getClickedBlock().equals(t.getTopBlock()))
                        t.removeTurret();
                        //player.getInventory().addItem(t.getSpawnBlock());
                    //TODO(Demetry) Give turret back to player, if omnitool was used give back all upgrades with it.
                }
            }
        }
        if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if(player.getItemInHand().equals(omniTool.getTool())){
                player.openInventory(new Shop(player).getShop());
            }
            //player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
        }
    }

    protected int getDirection(float playerRot){
        if(playerRot > 0) {
            if ((playerRot > 315 && playerRot < 360) || (playerRot > 0 && playerRot < 45)) {
                return 2;
            } else if (playerRot > 45 && playerRot < 135) {
                return 5; //west
            } else if (playerRot > 135 && playerRot < 225) {
                return 3;
            } else if (playerRot > 225 && playerRot < 315) {
                return 4; //east
            }
        }else if(playerRot < 0){
            if ((playerRot < -315 && playerRot > -360) || (playerRot < -0 && playerRot > -45)) {
                return 2;
            } else if (playerRot < -45 && playerRot > -135) {
                return 4; //west
            } else if (playerRot < -135 && playerRot > -225) {
                return 3;
            } else if (playerRot < -225 && playerRot > -315) {
                return 5; //east
            }
        }
        return 1;
    }

    public void reset(Player player){
        PlayerInventory inventory = player.getInventory();

        PlayerScoreBoard ps = new PlayerScoreBoard(player, towerDefense.getServer());

        inventory.clear();
        inventory.addItem(omniTool.getTool());
        inventory.addItem(SpawnBlocks.BASIC_TURRET_SPAWN_BLOCK.getItem());

        player.sendMessage("Welcome to Tower Defense on Bukkit: " + Bukkit.getVersion());
        player.sendMessage("Use the Omni Tool for things!");

    }
}
