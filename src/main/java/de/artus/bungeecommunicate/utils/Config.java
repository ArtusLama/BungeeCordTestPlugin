package de.artus.bungeecommunicate.utils;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    public static File ConfigFile = new File("plugins/BungeeCommunicate", "config.yml");
    public static FileConfiguration Config = YamlConfiguration.loadConfiguration(ConfigFile);

    public static void save() {
        try {
            Config.save(ConfigFile);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void EventPortal_setStatus(boolean active) {
        Config.set("eventportal.status", active);
        save();
    }
    public static boolean EventPortal_getStatus() {
        return Config.getBoolean("eventportal.status");
    }

    public static void EventPortal_setServerIp(String ip) {
        Config.set("eventportal.ip", ip);
        save();
    }
    public static String EventPortal_getServerIp() {
        return Config.getString("eventportal.ip");
    }

    public static void EventPortal_setPortalLocation(Location loc) {
        Config.set("eventportal.loc", loc);
        save();
    }
    public static Location EventPortal_getPortalLocation() {
        return Config.getLocation("eventportal.loc");
    }

}
