package me.pixar02.Extras.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.pixar02.Extras.Main;

public class spawn implements CommandExecutor {
	
	public Main plugin;
	public spawn(Main pl){
		plugin = pl;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "You have to be a player to perform this command!");
		}else{
			Player player = (Player) sender;
			if(player.hasPermission("ex.spawn")){
			if(plugin.getConfig().getString("spawn") == null){
				sender.sendMessage(ChatColor.RED + "No Spawn set!");
			}else{
				World world = Bukkit.getWorld(plugin.getConfig().getString("spawn.World"));
				double x = plugin.getConfig().getDouble("spawn.X");
				double y = plugin.getConfig().getDouble("spawn.Y");
				double z = plugin.getConfig().getDouble("spawn.Z");
				int yaw = plugin.getConfig().getInt("spawn.Yaw");
				int pitch = plugin.getConfig().getInt("spawn.Pitch");
				Location loc = new Location(world, x, y, z, yaw, pitch);
				player.teleport(loc);

			}
		}
		}
		return false;
	}
}
