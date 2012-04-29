package me.DJdur.NoGrief.Listener;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import me.DJdur.NoGrief.NoGrief;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
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
		Block b = e.getBlockPlaced();
		if(b.getType() == Material.TNT) {
			if(config.getBoolean("Block-TNT") == true) {
				e.setCancelled(true);
				b.setType(Material.AIR);
				p.sendMessage(ChatColor.DARK_GREEN + "[" +  config.getString("NoGrief-warning") + "] " + config.getString("TNT-error"));
				try {
					File log = new File("plugins/NoGrief/nogrief-log.txt");
					BufferedWriter bw = new BufferedWriter(new FileWriter(log, true));
					bw.write(p.getName() + " tried to place TNT in world " + p.getWorld().getName() + "!");
					bw.newLine();
					bw.close();
			  } catch (IOException ex) {
				  print("***************");
				  print("* Log failed! *");
				  print("***************");
				  ex.printStackTrace();
			  }
			}
			if(config.getBoolean("Block-TNT") == false) {
			}
		}
		if(b.getType() == Material.FIRE || b.getType() == Material.FLINT_AND_STEEL) {
			if(config.getBoolean("Block-Fire") == true) {
				e.setCancelled(true);
				b.setType(Material.AIR);
				p.sendMessage(e.getBlockPlaced().getType() + ". test");
				p.sendMessage(ChatColor.DARK_GREEN + "[" + config.getString("NoGrief-warning") + "] " + config.getString("Fire-error"));
				try {
					File log = new File("plugins/NoGrief/nogrief-log.txt");
					BufferedWriter bw = new BufferedWriter(new FileWriter(log, true));
					bw.write(p.getName() + " tried to place fire in world " + p.getWorld().getName() + "!");
					bw.newLine();
					bw.close();
				} catch (IOException ex) {
					print("***************");
					print("* Log failed! *");
					print("***************");
					ex.printStackTrace();
				}
			}
			if(config.getBoolean("Block-Fire") == false) {
			}
		}
		if(b.getType() == Material.LAVA || b.getType() == Material.LAVA_BUCKET) {
			if(config.getBoolean("Block-Lava") == true) {
				e.setCancelled(true);
			}
		}
	}
	
	public void print(String message) {
		System.out.println("[NoGrief] " + message);
	}
}