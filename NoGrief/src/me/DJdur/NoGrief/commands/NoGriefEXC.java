package me.DJdur.NoGrief.commands;

import me.DJdur.NoGrief.NoGrief;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class NoGriefEXC implements CommandExecutor {
	
	/*@Author DJdur
	 * This plugin is licensed to DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE.
	 */
	
	Plugin plugin;
	
	public NoGriefEXC(NoGrief main) {
		plugin = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("nogrief")) {
			if(sender.hasPermission("nogrief.reload")) {
				if(args.length == 0) {
					sender.sendMessage(ChatColor.RED + "/nogrief reload");
					sender.sendMessage(ChatColor.RED + "/nogrief help");
					return true;
				} else if(args.length == 1) {
					if(args[0].equalsIgnoreCase("reload")) {
						plugin.reloadConfig();
						sender.sendMessage(ChatColor.BLUE + "Reloaded config.");
						console(sender.getName() + " reloaded the config.");
						return true;
					}
					if(args[0].equalsIgnoreCase("help")) {
						sender.sendMessage(ChatColor.BLUE + "For more info, go to " + ChatColor.GOLD + "www.bukkit.org");
						return true;
					}
				}
			}
		}
		return false;
	}

	private void console(String message) {
		System.out.println("[NoGrief] " + message);
	}
}
