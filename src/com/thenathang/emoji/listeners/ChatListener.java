package com.thenathang.emoji.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.thenathang.emoji.configs.ConfigEmoji;

public class ChatListener implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onChat(AsyncPlayerChatEvent event) {
		if (!event.getPlayer().hasPermission("emoji.use"))
			return;
		
		String message = event.getMessage();
		
		for (Object obj : ConfigEmoji.emoji.getConfigurationSection("emoji").getKeys(false)) {
			if (message.contains(obj.toString())) {
				message = message.replace(obj.toString(), ConfigEmoji.emoji.getString("emoji." + obj.toString()));
				
				//event.getPlayer().sendMessage("Replaced " + obj.toString() + " with " + ConfigEmoji.emoji.getString("emoji." + obj.toString()));
				event.setMessage(message);
			}
		}
		
	}
}
