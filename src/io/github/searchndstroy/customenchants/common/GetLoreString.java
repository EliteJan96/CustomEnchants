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


public class GetLoreString {
	
	public static String getLoreString(List<String> lore, String enchantname) {
		
		String nothing = "";
		
		boolean found = false;
		int x = 0;
		int maxloresize = lore.size();
		while (found == false && x <= maxloresize) {
			
			int y = 0;
			
			String loreline = lore.get(y).toLowerCase();
			
			enchantname = enchantname.toLowerCase();
			if (loreline.contains(enchantname)) {
				
				String converted = loreline.replace(ChatColor.GRAY + enchantname + " ", nothing).toUpperCase();
				
				return converted;
			}
			y++;
			x++;
			
			return nothing;
		}
		
		return nothing;
	}

}
