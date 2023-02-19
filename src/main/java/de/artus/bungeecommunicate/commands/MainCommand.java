package de.artus.bungeecommunicate.commands;

import de.artus.bungeecommunicate.utils.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainCommand implements CommandExecutor, TabCompleter {

    public List<SubCommand> commands = new ArrayList<>();
    public void registerSubCommand(SubCommand command) {
        commands.add(command);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (!player.isOp()) return false;
            for (SubCommand subCommand : commands) {
                if (subCommand.getCommandName().equalsIgnoreCase(args[0])) {
                    subCommand.onExecute(player, Arrays.copyOfRange(args, 1, args.length));
                }
            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player player) {
            if (!player.isOp()) return null;

            List<String> completions = new ArrayList<>();
            List<String> allCommands = new ArrayList<>();

            for (SubCommand subCommand : commands) {
                if (args.length == 1) allCommands.add(subCommand.getCommandName());
                else if (subCommand.getCommandName().equalsIgnoreCase(args[0])) {
                    allCommands = subCommand.getCommands(Arrays.copyOfRange(args, 1, args.length), player);
                }
            }

            StringUtil.copyPartialMatches(args[args.length - 1], allCommands, completions);
            Collections.sort(completions);
            return completions;
        }
        return null;
    }
}
