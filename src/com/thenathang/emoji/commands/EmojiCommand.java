package com.thenathang.emoji.commands;

import mkremins.fanciful.FancyMessage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.thenathang.emoji.Emoji;
import com.thenathang.emoji.configs.ConfigConfig;
import com.thenathang.emoji.configs.ConfigEmoji;

public class EmojiCommand implements CommandExecutor {
	
	static Emoji plugin;
	
	public EmojiCommand(Emoji plugin) {
		EmojiCommand.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String l, String[] args) {
		if (!cmd.getName().equalsIgnoreCase("emoji"))
			return false;
		
		if(!s.hasPermission("emoji.list")) {
			s.sendMessage("You don't have permission to use this!");
			return true;
		}
		
		if (args.length > 0) {
			if (args[0].equalsIgnoreCase("getpack")) {
				Player player = (Player) s;
				
				player.setResourcePack(ConfigConfig.config.getString("resource-pack"));
				
				return true;
			}
			if (args.length > 1) {
				if (args[0].equalsIgnoreCase("sendpack")) {
					if (!s.hasPermission("emoji.sendpack")) {
						s.sendMessage("You don't have permission to use this!");
						return true;
					}
					
					if (Bukkit.getPlayer(args[1]) != null) {
						Bukkit.getPlayer(args[1]).setResourcePack(ConfigConfig.config.getString("resource-pack"));
						
						return true;
					}
					
					s.sendMessage("Player not found!");
					
					return true;
				}
			}
		}
		
		FancyMessage message = new FancyMessage("");
		
		for (Object obj : ConfigEmoji.emoji.getConfigurationSection("emoji").getKeys(false)) {
			message.then(ConfigEmoji.emoji.getString("emoji." + obj.toString())).color(ChatColor.WHITE).insert(ConfigEmoji.emoji.getString("emoji." + obj.toString())).tooltip("§8" + obj.toString()).color(ChatColor.DARK_GRAY);
		}
		
		s.sendMessage("");
		FancyMessage header = new FancyMessage("Emoji").color(ChatColor.GREEN).tooltip("§8By NathanG")
								  .then(" [Hover for Help]").color(ChatColor.GRAY).tooltip("§aHover over an emoji §8to see the code.", 
										  "§8  - You can type this into chat.", 
										  "§aShift click an emoji §8to automagically put it in.",
										  "",
										  "§8Seeing strange characters?",
										  "§8Do §a/emoji getpack");
		
								  
								
		header.send(s);
        message.send(s);
		
		return true;
	}
}
