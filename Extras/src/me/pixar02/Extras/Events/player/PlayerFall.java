package me.pixar02.Extras.Events.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.pixar02.Extras.Main;

public class PlayerFall implements Listener{
    public Main plugin;
    
    public PlayerFall(Main pl){
    plugin = pl;
    }
    
    @EventHandler
    public void onHit(PlayerMoveEvent event){
        if(plugin.getConfig().getBoolean("Teleport.tele") == true ){
            Player player = event.getPlayer();
            if(player.hasPermission("ex.teleport")){
                if(player.getLocation().getY() <= plugin.getConfig().getInt("Teleport.Y")){
                    if(plugin.getConfig().get("spawn.Y") != null){
                	player.performCommand("espawn");
                    }
                   
                }
            }
        }
    }
    
    
    
}
