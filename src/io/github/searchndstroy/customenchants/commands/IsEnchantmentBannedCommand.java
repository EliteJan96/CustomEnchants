package io.github.searchndstroy.customenchants.commands;

import java.util.ArrayList;
import java.util.List;

import io.github.searchndstroy.customenchants.common.CustomEnchants;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class IsEnchantmentBannedCommand implements CommandExecutor {
	
	private ArrayList<String> bannedenchants = (ArrayList<String>) CustomEnchants.bannedenchants;
	private ArrayList<String> enchantments = (ArrayList<String>) CustomEnchants.enchantments;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel,
			String[] args) {
		
		if (args.length == 0 || args.length > 1) {
			
			sender.sendMessage("Specify a enchantment!");
			return false;
		}
		
		String enchantment = args[0];
		
		boolean isBanned = isEnchantmentBanned(bannedenchants, enchantments, enchantment);
		
		if (isBanned) {
			System.out.println(bannedenchants);
			sender.sendMessage("Enchantment " + enchantment + " is disabled!");
			return true;
		} else {
			System.out.println(bannedenchants);
			sender.sendMessage("Enchantment " + enchantment + " isn't disabled!");
			return false;
		}
	}
	
	public static boolean isEnchantmentBanned(List<String> bannedenchants, List<String> enchantments, String enchantment) {
		
		if (!enchantments.contains(enchantment))
			return false;
		
		if (bannedenchants.contains(enchantment))
			return true;
		else
			return false;
		
	}

}
