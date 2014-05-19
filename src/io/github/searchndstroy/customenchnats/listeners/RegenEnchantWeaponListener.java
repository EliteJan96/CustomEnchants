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

import io.github.searchndstroy.customenchnats.common.Balh;
import io.github.searchndstroy.customenchnats.common.GetLoreLine;
import io.github.searchndstroy.customenchnats.common.RomanNumeralCoverterToInt;

import java.util.List;

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
	
	private static final String secondstypepath = "regenweapon.TypeForSeconds";
	private static final String defaultsecondspath = "regenweapon.defaultseconds";
	private static final String amplifiertypepath = "regenweapon.TypeForAmplifier";
	private static final String defaultamplifierpath = "regenweapon.defaultamplifier";
	private static final String secondstoworkwith = "regenweapon.Add/MultiplySecondsBy";
	private static final String amplifiertoworkwith = "regenweapon. Add/MultiplyAmplifierBy";
	
	@EventHandler(ignoreCancelled = true)
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		
		
		
		Entity damager = e.getDamager();
		
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
		
		List<String> lore = im.getLore();
		String nametype = "RegenWeapon";
		
		if (lore.contains("RegenWeapon ")) {
			
			int line = GetLoreLine.getLoreLine(player, lore, nametype);
			
			String lore1 = lore.get(line);
			String rm = lore1.replace("RegenWeapon ", "");
			
			int converted = RomanNumeralCoverterToInt.romanToDecimal(rm);
			
			int seconds = Balh.getSeconds(secondstypepath, defaultsecondspath, secondstoworkwith, converted);
			int amplifier = Balh.getAmplifier(amplifiertypepath, defaultamplifierpath, converted);
			
			PotionEffect potion = new PotionEffect(PotionEffectType.REGENERATION, seconds, amplifier);
			player.addPotionEffect(potion);
			
		}
	}

}
