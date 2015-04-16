package com.thenathang.emoji.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.thenathang.emoji.configs.ConfigConfig;

public class JoinListener implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent event) {
		if (!ConfigConfig.config.getBoolean("send-resource-pack-on-join"))
			return;
		
		event.getPlayer().setResourcePack(ConfigConfig.config.getString("resource-pack"));
	}
	
}
