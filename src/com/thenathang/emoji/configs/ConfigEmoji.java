package com.thenathang.emoji.configs;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

import com.thenathang.emoji.Emoji;

public class ConfigEmoji {
	public static YamlConfiguration emoji;
	private static Emoji plugin;
	static File emojiFile;
	
	public ConfigEmoji(Emoji plugin) {
		ConfigEmoji.plugin = plugin;
		
		loadEmoji();
	}
	
	public void loadEmoji() {
		emojiFile = new File(plugin.getDataFolder() + File.separator + "emoji.yml");
		
        if(!emojiFile.exists())
        	plugin.saveResource("emoji.yml", true);
        
        emoji = YamlConfiguration.loadConfiguration(emojiFile);
	}
}
