package ca.demetryromanowski.tdb.inventory;

import ca.demetryromanowski.tdb.blocks.SpawnBlocks;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Shop{
    public static Inventory inventory;

    public Shop(Player player){
        inventory = Bukkit.createInventory(player, 18, "Shop");

        inventory.clear();
        for(SpawnBlocks item : SpawnBlocks.values()){
            inventory.addItem(item.getItem());
        }
    }

    public Inventory getShop(){
        return inventory;
    }

    @SuppressWarnings("unused")
    public void addItem(ItemStack itemStack){
        inventory.addItem(itemStack);
    }

    @SuppressWarnings("unused")
    public void addItemAt(int index, ItemStack itemStack){
        inventory.setItem(index, itemStack);
    }
}
