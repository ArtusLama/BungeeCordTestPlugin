package de.artus.bungeecommunicate.utils;

import org.bukkit.entity.Player;

import java.util.List;

public interface SubCommand {

    void onExecute(Player sender, String[] args);
    String getCommandName();
    List<String> getCommands(String[] args, Player sender);

}
