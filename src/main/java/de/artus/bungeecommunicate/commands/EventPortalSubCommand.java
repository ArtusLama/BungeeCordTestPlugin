package de.artus.bungeecommunicate.commands;

import de.artus.bungeecommunicate.utils.Config;
import de.artus.bungeecommunicate.utils.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class EventPortalSubCommand implements SubCommand {


    @Override
    public void onExecute(Player sender, String[] args) {
        if (sender.isOp()) {
            if (args[0].equalsIgnoreCase("setStatus")) {
                if (args[1].equalsIgnoreCase("on")) Config.EventPortal_setStatus(true);
                else if (args[1].equalsIgnoreCase("off")) Config.EventPortal_setStatus(false);
                else sender.sendMessage(ChatColor.RED + "Wrong arguments! use 'setStatus on/off'!");
            } else if (args[0].equalsIgnoreCase("setBungeeCordServerName")) {
                if (args.length == 2) {
                    Config.EventPortal_setServerIp(args[1]);
                } else sender.sendMessage(ChatColor.RED + "Wrong arguments! use 'setPortalServerIp [ServerIp]'!");
            } else if (args[0].equalsIgnoreCase("setPortalLocation")) {
                if (args.length == 4) {
                    Config.EventPortal_setPortalLocation(new Location(sender.getWorld(), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])));
                } else sender.sendMessage(ChatColor.RED + "Wrong arguments! use 'setPortalLocation [x] [y] [z]'!");
            }
        }
    }

    @Override
    public String getCommandName() {
        return "eventportal";
    }

    @Override
    public List<String> getCommands(String[] args, Player sender) {
        List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            completions.add("setStatus");
            completions.add("setBungeeCordServerName");
            completions.add("setPortalLocation");
        } else if (args.length == 2) {
            switch (args[0].toLowerCase()) {
                case "setstatus" -> {
                    completions.add("on");
                    completions.add("off");
                }
                case "setportallocation" -> {
                    completions.add(String.valueOf(sender.getTargetBlock(5).getX()));
                }
            }
        } else if (args.length == 3) {
            if (args[0].equalsIgnoreCase("setportallocation")) {
                completions.add(String.valueOf(sender.getTargetBlock(5).getY()));
            }
        } else if (args.length == 4) {
            if (args[0].equalsIgnoreCase("setportallocation")) {
                completions.add(String.valueOf(sender.getTargetBlock(5).getZ()));
            }
        }
        return completions;
    }


}
