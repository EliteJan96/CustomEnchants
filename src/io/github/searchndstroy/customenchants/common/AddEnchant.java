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


package io.github.searchndstroy.customenchants.common;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

public class AddEnchant {

	public static void AddEnchantToItem(AddEnchantType type, ItemMeta itemmeta, List<String> lore, Player player, int tierlevel) {

		if (ItemHasCurrentEnchant(itemmeta))
			return;
		
		int maxtierlevel = CustomEnchants.config.getInt(type.toString().toLowerCase() + ".MaximumTierLevel");
		
		if (tierlevel <= 0) {
			
			player.sendMessage(ChatColor.RED + "You cannot have a tier of " + tierlevel);
			return;
		}
		
		if (tierlevel > maxtierlevel && maxtierlevel != -1) {
			
			player.sendMessage(ChatColor.RED + "You cannot have a tier higher than the maximum! ");
			player.sendMessage(ChatColor.RED + "Max tier level is: " + maxtierlevel);
			return;
		}
		
		if (maxtierlevel == -1) {
			
		}
		
		String tierlevelconverted = RomanNumeralConverter.IntegerToRomanNumeral(tierlevel);
		
		switch(type) {
		
		case REGENWEAPON:
			lore.add("RegenWeapon " + tierlevelconverted);
			player.sendMessage(ChatColor.GREEN + "Sucessfully enchanted your item with " + type.toString());
			break;
		default:
			player.sendMessage("Type in a valid enchantment name!");
			break;
		}

	}

	public static boolean ItemHasCurrentEnchant(ItemMeta itemmeta) {

		return false;

	}
}
