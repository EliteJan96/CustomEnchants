package io.github.searchndstroy.commands;

import io.github.searchndstroy.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCustomEnchants implements CommandExecutor {

	Main plugin;

	public ReloadCustomEnchants(Main instance) {

		plugin = instance;

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String cmdlabel, String[] args) {

		if (cmdlabel.equalsIgnoreCase("reloadcustomenchants")
				|| cmdlabel.equalsIgnoreCase("rce")) {
			
			plugin.reloadCustomConfig();
			sender.sendMessage(ChatColor.RED + "Config reloaded!");

			return true;
		}

		return false;
	}
}
