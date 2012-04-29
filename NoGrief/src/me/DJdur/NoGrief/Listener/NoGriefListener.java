package me.DJdur.NoGrief.Listener;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import me.DJdur.NoGrief.NoGrief;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;

public class NoGriefListener implements Listener {
	
	/*@Author DJdur
	 * This plugin is licensed to DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE.
	 */
	
	Plugin plugin;
	
	public NoGriefListener(NoGrief main) {
		plugin = main;
	}
	
	@EventHandler
	public void onBlockPlace(final BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Configuration config = plugin.getConfig();
		if(e.getBlockPlaced().getType() == Material.TNT) {
			if(config.getBoolean("Block-TNT") == true) {
				e.setCancelled(true);
				e.getBlockPlaced().setType(Material.AIR);
				p.sendMessage(ChatColor.DARK_GREEN + "[" +  config.getString("NoGrief-warning") + "] " + config.getString("TNT-error"));
				try {
					File log = new File("plugins/NoGrief/nogrief-log.txt");
					BufferedWriter bw = new BufferedWriter(new FileWriter(log, true));
					bw.write(p.getName() + " tried to place a TNT in world " + p.getWorld().getName() + "!");
					bw.newLine();
					bw.close();
			  } catch (IOException exception) {
				  print("**************");
				  print("* Log failed! *");
				  print("**************");
				  exception.printStackTrace();
			  }
			}
			if(config.getBoolean("Block-TNT") == false) {
			}
		}
		if(e.getBlockPlaced().getType() == Material.FIRE) {
			if(config.getBoolean("Block-Fire")) {
				
			}
		}
	}
	
	public void print(String message) {
		System.out.println("[NoGrief] " + message);
	}
}