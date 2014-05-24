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

package io.github.searchndstroy.customenchants.listeners;

import io.github.searchndstroy.customenchants.common.CustomEnchants;
import io.github.searchndstroy.customenchants.common.GetLoreString;
import io.github.searchndstroy.customenchants.common.RomanNumeralConverterToInt;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ExtremeKnockbackArrowListener implements Listener {
	
	private int maxtierlevel = CustomEnchants.config.getInt("extremeknocbackarrow.MaximumTierLevel");
	private String enchantmentname = "ExtremeKnocbackArrow";
	private String type = CustomEnchants.config.getString("extremeknockbackarrow.TypeForVelocity");
	
	@EventHandler(ignoreCancelled = true)
	public void onEntityShootBowEvent(EntityShootBowEvent e) {
		
		Entity damager = e.getEntity();
		
		if (!(damager instanceof Player))
			return;
		
		Player player = (Player) damager;
		
		ItemStack bow = e.getBow();
		
		if (bow == null || bow.getType() == Material.AIR)
			return;
		
		ItemMeta im = bow.getItemMeta();
		
		if (!im.hasLore())
			return;
		
		List<String> lore = im.getLore();
		
		String string = GetLoreString.getLoreString(lore, maxtierlevel, enchantmentname);
		
		int tierlevel = RomanNumeralConverterToInt.romanToDecimal(string);
		
		if (tierlevel == 0)
			return;
		
	}

}
