package de.artus.bungeecommunicate;

import de.artus.bungeecommunicate.commands.EventPortalSubCommand;
import de.artus.bungeecommunicate.commands.MainCommand;
import de.artus.bungeecommunicate.listeners.EventPortalListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {


    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        plugin.getServer().getMessenger().registerOutgoingPluginChannel(plugin, "BungeeCord");


        // - - - - - -   C O M M A N D S   - - - - - - -
        MainCommand mainCommand = new MainCommand();

        mainCommand.registerSubCommand(new EventPortalSubCommand());


        getCommand("bungeecommunicate").setExecutor(mainCommand);

        // - - - - - -   L I S T E N E R S   - - - - - - -
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new EventPortalListener(), plugin);

    }

    @Override
    public void onDisable() {
        plugin.getServer().getMessenger().unregisterOutgoingPluginChannel(plugin);
    }
}
