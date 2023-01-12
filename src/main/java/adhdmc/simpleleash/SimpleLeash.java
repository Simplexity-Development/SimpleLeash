package adhdmc.simpleleash;

import adhdmc.simpleleash.listener.LeashListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleLeash extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new LeashListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
