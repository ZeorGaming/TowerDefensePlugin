package ca.demetryromanowski.tdb.core;

/**
 * @author: Demetry
 * @syn: Main class that gets loaded for the plugin
 * TODO(Demetry):
 */

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class TowerDefense extends JavaPlugin{
    EventListener listener;

    @Override
    public void onEnable(){
        getLogger().info("Congrats, you have Tower Defense Installed!");
        listener = new EventListener(this);
        getServer().getPluginManager().registerEvents(listener, this);

        for(Player online : Bukkit.getOnlinePlayers()) {
            listener.reset(online);
        }
    }

    @Override
    public void onDisable(){
        getLogger().info("Y U DISABLE ME :(");
    }

    public void printMessage(String message){
        getLogger().info(message);
    }
}
