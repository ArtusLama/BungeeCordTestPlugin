package de.artus.bungeecommunicate;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class MessageSender {


    public static void connectToServer(Player player, String serverName, String displayName) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

        try {
            dataOutputStream.writeUTF("Connect");
            dataOutputStream.writeUTF(serverName);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        player.sendPluginMessage(Main.plugin, "BungeeCord", byteArrayOutputStream.toByteArray());
        player.sendMessage(ChatColor.GRAY + "Connecting to " + ChatColor.GREEN + displayName + ChatColor.GRAY + "...");

    }

}
