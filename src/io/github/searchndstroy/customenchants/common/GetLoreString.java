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


public class GetLoreString {
	
	public static String getLoreString(List<String> lore, int maxtierlevel, String enchantname) {
		
		String nothing = "";
		
		boolean found = false;
		int x = 0;
		while (found == false && x != maxtierlevel) {
			
			int y = 0;
			
			String loreline = lore.get(y);
			
			y++;
			
			loreline.toLowerCase();
			
			if (loreline.contains(enchantname.toLowerCase())) {
				
				String converted = loreline.replace(enchantname.toLowerCase(), nothing);
				
				return converted;
			}
			
			return nothing;
		}
		
		return nothing;
	}

}
