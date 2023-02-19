package de.artus.bungeecommunicate.utils;

import de.artus.bungeecommunicate.Main;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConnectCooldown {

    public static HashMap<Player, String> players = new HashMap<>();

    public static void setDelay(Player player, String serverName, int delay) {
        if (!players.containsKey(player)){
            players.put(player, serverName);

            new BukkitRunnable() {
                @Override
                public void run() {
                    players.remove(player);
                }
            }.runTaskLater(Main.plugin, delay * 20L);
        }
    }


}
