package de.artus.bungeecommunicate.listeners;

import de.artus.bungeecommunicate.MessageSender;
import de.artus.bungeecommunicate.utils.Config;
import de.artus.bungeecommunicate.utils.ConnectCooldown;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class EventPortalListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (Config.EventPortal_getStatus()) {
            if (Config.EventPortal_getPortalLocation().getWorld().equals(e.getTo().getWorld())){
                if (Config.EventPortal_getPortalLocation().distance(e.getTo()) < 1) {
                    if (!ConnectCooldown.players.containsKey(e.getPlayer())) {
                        MessageSender.connectToServer(e.getPlayer(), Config.EventPortal_getServerIp(), "WinterEvent");
                        ConnectCooldown.setDelay(e.getPlayer(), "eventserver", 6);
                    }
                }
            }
        }
    }


}
