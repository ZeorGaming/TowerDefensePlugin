package ca.demetryromanowski.tdb.blocks;

/**
 * @author: Demetry
 * @syn: Super class for all spawn blocks
 */

import ca.demetryromanowski.tdb.enchantments.Glow;
import ca.demetryromanowski.tdb.turrets.Turret;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Field;
import java.util.List;

public class SpawnBlock {
    ItemStack itemStack;
    ItemMeta itemMeta;
    Glow glow = new Glow(120);

    Turret turret;

    public SpawnBlock(Material material, String displayName){
        itemStack = new ItemStack(material, 1);
        try{
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);

            Enchantment.registerEnchantment(glow);
        }catch(Exception e){ /*Unhandled*/ }

        itemStack.addUnsafeEnchantment(glow, 1);

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
}
