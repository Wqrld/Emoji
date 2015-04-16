package com.thenathang.emoji.configs;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

import com.thenathang.emoji.Emoji;

public class ConfigConfig {
	public static YamlConfiguration config;
	private static Emoji plugin;
	static File configFile;
	
	public ConfigConfig(Emoji plugin) {
		ConfigConfig.plugin = plugin;
		
		loadConfig();
	}
	
	public void loadConfig() {
		configFile = new File(plugin.getDataFolder() + File.separator + "config.yml");
		
        if(!configFile.exists())
        	plugin.saveResource("config.yml", true);
        
        config = YamlConfiguration.loadConfiguration(configFile);
	}
}
