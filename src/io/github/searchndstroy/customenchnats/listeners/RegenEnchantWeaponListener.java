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

package io.github.searchndstroy.customenchnats.listeners;

import io.github.searchndstroy.customenchnats.common.RomanNumeralConverter;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RegenEnchantWeaponListener implements Listener {
	
	@EventHandler(ignoreCancelled = true)
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		
		Entity damager = e.getDamager();
		Entity target = e.getEntity();
		
		if (!(damager instanceof Player))
			return;
		
		Player player = (Player) damager;
		
		PlayerInventory pi = player.getInventory();
		
		ItemStack iteminhand = pi.getItemInHand();
		
		if (iteminhand == null || iteminhand.getType() == Material.AIR || pi == null)
			return;
		
		ItemMeta im = iteminhand.getItemMeta();
		
		if (!im.hasLore())
			return;
		
		if (im.getLore().contains(ChatColor.RED + "Regen " + RomanNumeralConverter.IntegerToRomanNumeral(level))) {
			
			
			
			PotionEffect potion = new PotionEffect(PotionEffectType.REGENERATION, seconds, amplifier);
			player.addPotionEffect(potion);
			
		}
	}

}
