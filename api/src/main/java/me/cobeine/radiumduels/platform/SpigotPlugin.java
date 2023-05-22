package me.cobeine.radiumduels.platform;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public abstract class SpigotPlugin extends JavaPlugin implements DuelsPlugin {


    public void onEnable() {
        init();
    }

    public void onDisable() {
        fini();
    }
    public static String c(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
    public static String error(String s) {
        return c("&c&lERROR &r" +s);
    }
    public static String warn(String s) {
        return c("&eWARNING &r" +s);
    }

}
