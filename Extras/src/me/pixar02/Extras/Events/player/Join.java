package me.pixar02.Extras.Events.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.pixar02.Extras.Main;

public class Join implements Listener {

	public Main plugin;
	public Join(Main pl){
		plugin = pl;
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
	 Player player = event.getPlayer();
	 if(plugin.getConfig().getString("spawn.World") != null){
		 if(player.hasPermission("ex.spawn")|| player.isOp()){
		 	if(!(player.hasPermission("ex.exempt"))){
			 player.performCommand("espawn");
		 		}
	 		}
	 	}
	}
}
