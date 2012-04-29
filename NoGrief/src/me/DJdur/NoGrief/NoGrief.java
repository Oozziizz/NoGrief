package me.DJdur.NoGrief;

import me.DJdur.NoGrief.Listener.NoGriefListener;
import me.DJdur.NoGrief.commands.NoGriefEXC;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class NoGrief extends JavaPlugin {
	
	FileConfiguration config;
	
	public NoGriefListener Listener = new NoGriefListener(this);
	
	@Override
	public void onDisable() {
		console("Disabled!");
	}
	@Override
	public void onEnable() {
		console("Enabled");
		console("By DJdur!");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(Listener, this);
		config = getConfig();
		config.options().header("This is the config for NoGrief. \nYou can specify the messages under.");
		config.options().copyDefaults(true);
		config.addDefault("NoGrief-warning", "§1*WARNING* §2NoGrief §1*WARNING*");
		config.addDefault("Block-TNT", true);
		config.addDefault("TNT-error", "§cYou cant place TNT!");
		config.addDefault("Block-Fire", true);
		config.addDefault("Fire-error", "§cYou cant place fire.");
		saveConfig();
		getCommands();
	}
	
	public void getCommands() {
		getCommand("nogrief").setExecutor(new NoGriefEXC(this));
	}
	
	public void console(String message) {
		System.out.println("[NoGrief] " + message);
	}
}
