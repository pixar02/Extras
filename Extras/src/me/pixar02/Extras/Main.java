package me.pixar02.Extras;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.pixar02.Extras.Commands.setspawn;
import me.pixar02.Extras.Commands.spawn;
import me.pixar02.Extras.Events.player.Join;

public class Main extends JavaPlugin{

	public void onEnable(){
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		registerCommands();
		registerEvents();
		registerConfig();
		
		logger.info(pdfFile.getName() + " has been enabled (V." + pdfFile.getVersion() + ")");
	}
	public void onDisable(){
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		logger.info(pdfFile.getName() + " has been disabled (V." + pdfFile.getVersion() + ")");
		
	}
	
	
	public void registerEvents(){
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Join(this), this);
	}
	public void registerCommands(){
		getCommand("esetspawn").setExecutor(new setspawn(this));
		getCommand("espawn").setExecutor(new spawn(this));
	}
	public void registerConfig(){
	getConfig().options().copyDefaults(true);
	saveConfig();
	}
}
