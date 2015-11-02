package ca.demetryromanowski.tdb.tools;

import ca.demetryromanowski.tdb.Interfaces.ITool;

import ca.demetryromanowski.tdb.enchantments.Glow;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class OmniTool implements ITool{
    ItemStack itemStack;
    List<String> lore = new ArrayList<>();
    Glow glow = new Glow(120);

    public OmniTool(){
        itemStack = new ItemStack(Material.BLAZE_ROD, 1);
        try{
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);

            Enchantment.registerEnchantment(glow);
        }catch(Exception e){ /*OmniTool*/ }

        itemStack.addUnsafeEnchantment(glow, 1);

        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("Tower Defense Omni Tool");

        lore.add(ChatColor.DARK_GREEN + "Left Click to Pickup Turret");
        lore.add(ChatColor.DARK_PURPLE + "Right Click in air to open Shop");

        itemMeta.setLore(lore);

        itemStack.setItemMeta(itemMeta);
    }

    @Override
    public ItemStack getTool() {
        return this.itemStack;
    }
}
