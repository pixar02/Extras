package me.pixar02.Extras.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.pixar02.Extras.Main;


public class setspawn implements CommandExecutor {

	public Main plugin;
	public setspawn(Main pl){
		plugin = pl;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "You have to be a player to perform this command!");
		}else{
			Player player = (Player) sender;
			Location loc = player.getLocation();
			if(plugin.getConfig().getString("spawn") == null){

				plugin.getConfig().set("spawn.World", loc.getWorld().getName());
				plugin.getConfig().set("spawn.X", loc.getX());
				plugin.getConfig().set("spawn.Y", loc.getY());
				plugin.getConfig().set("spawn.Z", loc.getZ());
				plugin.getConfig().set("spawn.Yaw", loc.getYaw());
				plugin.getConfig().set("spawn.Pitch", loc.getPitch());
				sender.sendMessage(ChatColor.GREEN + "New Spawn has been set!");
			}else{
				plugin.getConfig().set("spawn.World", loc.getWorld().getName());
				plugin.getConfig().set("spawn.X", loc.getX());
				plugin.getConfig().set("spawn.Y", loc.getY());
				plugin.getConfig().set("spawn.Z", loc.getZ());
				plugin.getConfig().set("spawn.Yaw", loc.getYaw());
				plugin.getConfig().set("spawn.Pitch", loc.getPitch());
				sender.sendMessage(ChatColor.GREEN + "New Spawn has been set!" + ChatColor.RED + " (You overrote the last spawn)");
			}
		}
		return false;
	}
}
