package io.github.searchndstroy.customenchants.common;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadConfigCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel,
			String[] args) {
		CustomEnchants.getPlugin(CustomEnchants.class).reloadConfig();
		sender.sendMessage(ChatColor.YELLOW + "Sucessfully reloaded the config!");
		return false;
	}

}
