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

package io.github.searchndstroy.customenchnats.common;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class AddEnchant {

	public static void AddEnchantToItem(AddEnchantType type, ItemStack itemstack, Player player) {

		if (ItemHasCurrentEnchant(itemstack))
			return;
		
		switch(type) {
		
		case REGENFOOD:
			break;
		
		default:
			break;
		}

	}

	public static boolean ItemHasCurrentEnchant(ItemStack itemstack) {

		return false;

	}
}
