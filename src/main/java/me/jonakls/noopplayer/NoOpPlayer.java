package me.jonakls.noopplayer;

import me.jonakls.noopplayer.command.MainCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class NoOpPlayer extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("noopplayer").setExecutor(new MainCommand(this));
    }

    @Override
    public void onDisable() {

    }
}
