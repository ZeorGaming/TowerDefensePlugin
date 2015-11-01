package ca.demetryromanowski.tdb.core;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class TowerDefense extends JavaPlugin{
    ItemStack itemStack;

    @Override
    public void onEnable(){
        getLogger().info("Congrats, you have Tower Defense Installed!");

        itemStack = new ItemStack(Material.BLAZE_ROD, 1);
        itemStack.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 1);

        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("Tower Defense Omni Tool");

        itemStack.setItemMeta(itemMeta);

        getServer().getPluginManager().registerEvents(new EventListener(itemStack), this);
    }

    @Override
    public void onDisable(){
        getLogger().info("Y U DISABLE ME :(");
    }
}
