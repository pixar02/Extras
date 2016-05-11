package me.pixar02.Extras.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.pixar02.Extras.Main;

public class reload implements CommandExecutor {
	
	public Main plugin;
	public reload(Main pl){
		plugin = pl;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "You have to be a player to perform this command!");
		}else{
			plugin.reloadConfig();
		}
		return false;
	}

}
