package me.DJdur.NoGrief;

import me.DJdur.NoGrief.Listener.NoGriefListener;
import me.DJdur.NoGrief.commands.NoGriefEXC;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class NoGrief extends JavaPlugin {
	
	/*@Author DJdur
	 * This plugin is licensed to DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE.
	 */
	
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
		config.options().header("This is the config for NoGrief. \nYou can specify the messages under. \nFire blocks for both fire and flint and steel. \nLava is for both lava and lavabucket, same with water and waterbucket.");
		config.options().copyDefaults(true);
		config.addDefault("NoGrief-warning", "§1*WARNING* §2NoGrief §1*WARNING*");
		config.addDefault("Block-TNT", true);
		config.addDefault("TNT-error", "§cYou can't place TNT!");
		config.addDefault("Block-Fire", true);
		config.addDefault("Fire-error", "§cYou can't place fire.");
		config.addDefault("Block-lava", true);
		config.addDefault("Lava-error", "§cYou can't place lava or lavabuckets.");
		config.addDefault("Block-water", true);
		config.addDefault("Water-error", "§cYou can't place water or waterbuckets.");
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
