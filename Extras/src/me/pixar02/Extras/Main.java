package me.pixar02.Extras;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.pixar02.Extras.Commands.reload;
import me.pixar02.Extras.Commands.setspawn;
import me.pixar02.Extras.Commands.spawn;
import me.pixar02.Extras.Events.player.Join;
import me.pixar02.Extras.Events.player.PlayerFall;

public class Main extends JavaPlugin{
	PluginDescriptionFile pdfFile = getDescription();
	public void onEnable(){
		Logger logger = getLogger();
		
		registerCommands();
		registerEvents();
		registerConfig();
		
		logger.info(pdfFile.getName() + " has been enabled (V." + pdfFile.getVersion() + ")");
		//getConfig().set("VR", pdfFile.getVersion());
	}
	public void onDisable(){
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		logger.info(pdfFile.getName() + " has been disabled (V." + pdfFile.getVersion() + ")");
		
	}
	
	
	public void registerEvents(){
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Join(this), this);
		pm.registerEvents(new PlayerFall(this), this);
	}
	public void registerCommands(){
		getCommand("esetspawn").setExecutor(new setspawn(this));
		getCommand("espawn").setExecutor(new spawn(this));
		getCommand("ereload").setExecutor(new reload(this));
	}
	public void registerConfig(){
	saveDefaultConfig();
	saveConfig();
	getConfig().set("VR", pdfFile.getVersion());
	saveConfig();
	}
}
