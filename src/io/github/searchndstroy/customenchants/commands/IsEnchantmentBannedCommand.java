package io.github.searchndstroy.customenchants.commands;

import io.github.searchndstroy.customenchants.common.CustomEnchants;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class IsEnchantmentBannedCommand implements CommandExecutor {
	
	private List<String> enchantments = CustomEnchants.enchantments;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel,
			String[] args) {
		
		if (args.length == 0 || args.length > 1) {
			
			sender.sendMessage(ChatColor.RED + "Specify a enchantment!");
			return false;
		}
		
		String enchantment = args[0];
		
		boolean isBanned = isEnchantmentBanned(enchantments, enchantment);
		
		if (!enchantments.contains(enchantment)) {
			
			sender.sendMessage("Enchantment " + enchantment + " doesn't exist!");
			return false;
		}
		
		if (isBanned) {
			sender.sendMessage(ChatColor.RED + "Enchantment " + enchantment + " is disabled!");
			return true;
		} else if (enchantments.contains(enchantment)){
			sender.sendMessage(ChatColor.GREEN + "Enchantment " + enchantment + " isn't disabled!");
			return true;
		}
		return false;
	}
	
	public static boolean isEnchantmentBanned(List<String> enchantments, String enchantment) {
		
		if (!enchantments.contains(enchantment))
			return false;
		
		boolean banned = CustomEnchants.config.getBoolean(enchantment.toLowerCase() + ".disabled");
		
		if (banned)
			return true;
		else
			return false;
		
	}

}
