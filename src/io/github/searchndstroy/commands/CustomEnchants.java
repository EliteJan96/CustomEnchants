package io.github.searchndstroy.commands;

import io.github.searchndstroy.Main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomEnchants implements CommandExecutor {

	Main plugin;

	public CustomEnchants(Main instance) {

		plugin = instance;

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel,
			String[] args) {

		if (!(sender instanceof Player)) {

			sender.sendMessage("You can only run this command as a player!");

		} else {
			
			String usage = ChatColor.RED + "/customenchants enchant <enchantment name> <tier>";
			
			if (args.length <= 2) {
				
				sender.sendMessage("Please use three arguments, not " + args.length);
				sender.sendMessage(usage);
				return false;
			}
			
			if (args.length > 3) {
				
				sender.sendMessage("Please use three arguments, not " + args.length);
				sender.sendMessage(usage);
				return false;
			}
			
			Player player = (Player) sender;
			ItemStack iteminhand = player.getInventory().getItemInHand();
			ItemMeta iteminhandim = iteminhand.getItemMeta();
			
			if (iteminhand.getType() == null || iteminhand.getType() == Material.AIR) {
				
				sender.sendMessage(ChatColor.RED + "You have to have a valid item in your hand!");
				return false;
				
			} else if (cmdlabel.equalsIgnoreCase("customenchants") || cmdlabel.equalsIgnoreCase("ce")) {
				
				if (args[0].equalsIgnoreCase("enchant")) {
					
					if (args[1].equalsIgnoreCase("regen")) {
						
						if (iteminhandim.hasLore()) {
							
							if (iteminhandim.getLore().contains("§r§7Regen ")) {
								
								sender.sendMessage(ChatColor.RED + "You cannot have the same enchantment twice on a item!");
								
								return false;
							}
							
							//Start testing for input here(kinda)
							
						} else if (args[2].equalsIgnoreCase("1")) {
							
							if (iteminhandim.hasLore() == true) {
						
							ItemMeta thisitem = iteminhand.getItemMeta();
							
							List<String> derp = iteminhandim.getLore();
							
							derp.add("§r§7Regen I");
							
							thisitem.setLore(derp);
							
							iteminhand.setItemMeta(thisitem);
							
							sender.sendMessage(ChatColor.GREEN + "Successfully enchanted your item!");
							} else {
								
								List<String> derp = new ArrayList<String>();
								
								derp.add("§r§7Regen I");
								
								iteminhandim.setLore(derp);
								
								iteminhand.setItemMeta(iteminhandim);
							
						}
							return false;
						}
						
						return false;
					}
					
					return false;
				}
				
				return false;
			}
			

		}

		return false;
	}
}