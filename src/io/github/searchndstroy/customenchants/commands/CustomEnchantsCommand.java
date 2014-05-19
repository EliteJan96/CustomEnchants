/*
 *     This file is part of CustomEnchants.

    CustomEnchants is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    CustomEnchants is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with CustomEnchants.  If not, see <http://www.gnu.org/licenses/>.
 */


package io.github.searchndstroy.customenchants.commands;

import java.util.List;

import io.github.searchndstroy.customenchants.common.AddEnchant;
import io.github.searchndstroy.customenchants.common.AddEnchantType;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomEnchantsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel,
			String[] args) {
		
		if (args.length < 3 || args.length > 3) {
			
			sender.sendMessage(ChatColor.RED + "/customenchants enchant <enchantname> <tierlevel>");
			
			return false;
		}
		
		if (!(sender instanceof Player)) {
			
			sender.sendMessage("You cannot run this command as console!");
			
		} else {
			Player player = (Player) sender;
			
			ItemStack itemstack = player.getItemInHand();
			
			if (itemstack == null || itemstack.getType() == Material.AIR) {
				
				player.sendMessage("Put a item in your hand!");
				
				return false;
			}
			
			ItemMeta itemmeta = itemstack.getItemMeta();
			
			List<String> lore = itemmeta.getLore();
			
			if (args[0].equalsIgnoreCase("enchant")) {
				
				if (args[1].equalsIgnoreCase("RegenWeapon")) {
					
					int tierlevel = Integer.parseInt(args[2]);
					AddEnchant.AddEnchantToItem(AddEnchantType.REGENWEAPON, itemmeta, lore, player, tierlevel);
					
					
					return true;
				}
				
				return false;
			}
			
			return false;
		}
		
		return false;
	}

}
