package ca.demetryromanowski.tdb.blocks;

/**
 * @author: Demetry
 * @syn: Super class for all spawn blocks
 */

import ca.demetryromanowski.tdb.turrets.Turret;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class SpawnBlock {
    ItemStack itemStack;
    ItemMeta itemMeta;
    Turret type;

    public SpawnBlock(Turret type, Material material, String displayName){
        this.type = type;
        itemStack = new ItemStack(material, 1);

        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);

        itemStack.setItemMeta(itemMeta);
    }

    public ItemStack getBlock(){
        return itemStack;
    }

    public void setLore(List<String> lore){
        itemMeta.setLore(lore);
    }

    public Turret getType(){
        return this.type;
    }
}
