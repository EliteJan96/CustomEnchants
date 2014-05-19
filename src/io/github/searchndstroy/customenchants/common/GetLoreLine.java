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

import org.bukkit.entity.Player;

public class GetLoreLine {
	
	public static int getLoreLine(Player player, List<String> lore, String nametype) {
		
		int x = 0;
		
		while (x == 0) {
			
			int y = 0;
			
			String line1 = lore.get(y++);
			
			if (line1.contains(nametype + " ")) {
				
				++x;
				return y - 1;
				
			}
			
		}
		return 0;
	}

}
