package com.thenathang.emoji;

import org.bukkit.plugin.java.JavaPlugin;

import com.thenathang.emoji.commands.EmojiCommand;
import com.thenathang.emoji.configs.ConfigConfig;
import com.thenathang.emoji.configs.ConfigEmoji;
import com.thenathang.emoji.listeners.ChatListener;
import com.thenathang.emoji.listeners.JoinListener;

public class Emoji extends JavaPlugin {
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new ChatListener(), this);
		getServer().getPluginManager().registerEvents(new JoinListener(), this);
		
		getCommand("emoji").setExecutor(new EmojiCommand(this));
		
		new ConfigEmoji(this);
		new ConfigConfig(this);
	}
	
}
