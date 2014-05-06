package io.github.searchndstroy.commands;

import io.github.searchndstroy.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SaveCustomEnchants implements CommandExecutor {

	Main plugin;

	public SaveCustomEnchants(Main instance) {

		plugin = instance;

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel,
			String[] args) {
		
		if (cmdlabel.equalsIgnoreCase("sce") || cmdlabel.equalsIgnoreCase("savecustomenchants")) {
			
			plugin.reloadCustomConfig();
			sender.sendMessage(ChatColor.GREEN + "Reloaded the customenchants config!");
			
			return true;
		}
		
		return false;
	}

}
