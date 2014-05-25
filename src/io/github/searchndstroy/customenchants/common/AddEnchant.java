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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AddEnchant {

	
	public static void AddEnchantToItem(String type, ItemStack itemstack, ItemMeta itemmeta, List<String> lore, Player player, int tierlevel, boolean bypasslorecheck) {

		int maxtierlevel = CustomEnchants.config.getInt(type.toLowerCase() + ".MaximumTierLevel");
		
		if (!CustomEnchants.enchantments.contains(type))
			return;

		if (ItemHasCurrentEnchant(itemmeta, lore, type) && !bypasslorecheck) {
			
			player.sendMessage(ChatColor.RED + "This item already has " + type + " on it!");
			return;
		}

		if (tierlevel <= 0) {

			player.sendMessage(ChatColor.RED + "You cannot have a tier of " + tierlevel);
			return;
		}

		if (tierlevel > maxtierlevel && maxtierlevel != -1) {

			player.sendMessage(ChatColor.RED + "You cannot have a tier higher than the maximum! ");
			player.sendMessage(ChatColor.RED + "Max tier level is: " + maxtierlevel);
			return;
		}

		String tierlevelconverted = RomanNumeralConverter.IntegerToRomanNumeral(tierlevel);
		
		player.sendMessage(ChatColor.GREEN + "Sucessfully enchanted your item with " + type + " " + tierlevel);
		
		lore.add(ChatColor.GRAY + type + " " + tierlevelconverted);
		itemmeta.setLore(lore);
		itemstack.setItemMeta(itemmeta);
	}

	public static boolean ItemHasCurrentEnchant(ItemMeta itemmeta, List<String> lore, String type) {
		
		if (!itemmeta.hasLore())
			return false;

		if (lore.isEmpty() || lore == null)
			return false;

		int lorelength = lore.size();

		boolean result = DoesThisItemContainEnchantment(lorelength, lore, type);

		if (result == true)
			return true;
		else 
			return false;

	}

	private static boolean DoesThisItemContainEnchantment(int lorelength, List<String> lore, String type) {

		boolean found = false;
		int x = 0;

		while (found == false && x != lorelength) {

			String loreline = lore.get(x);

			loreline.toLowerCase();

			if (loreline.contains(type)) {

				found = true;
				return found;
			} else
				x++;

		}
		return found;


	}
}