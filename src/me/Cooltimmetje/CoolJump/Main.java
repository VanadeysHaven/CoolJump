package me.Cooltimmetje.CoolJump;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This class has been created on 19-5-2015 at 19:14 by cooltimmetje.
 */
public class Main extends JavaPlugin {

    private static Plugin plugin;
    private long startLoadTime;
    private long loadTime;

    @Override
    public void onEnable(){
        startLoad();
        plugin = this;

        getLogger().info("-=- This Plugin is using the Cooltimmetje Plugin API -=-");
        getLogger().info("Registering Events...");
        registerEvents(this, new Listeners());

        getLogger().info("Registering Commands...");
        getCommand("cooljump").setExecutor(new ReloadCommand());

        getLogger().info("Reading Config...");
        this.saveDefaultConfig();
        Listeners.upwardForce = this.getConfig().getDouble("UpwardForce");
        Listeners.forwardForce = this.getConfig().getDouble("ForwardForce");

        stopLoad();
        getLogger().info("Done! Load time: (" + loadTime + "ms)");
    }

    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    public void onDisable(){
        getLogger().info("Disabled!");
        plugin = null;
    }

    private void startLoad(){
        startLoadTime= System.currentTimeMillis();
    }

    private void stopLoad() {
        loadTime = System.currentTimeMillis() - startLoadTime;
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
