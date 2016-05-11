package me.pixar02.Extras.Commands;

import org.bukkit.ChatColor;
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
			
		}
		return false;
	}
}
