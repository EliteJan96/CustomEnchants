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

import io.github.searchndstroy.customenchants.commands.IsEnchantmentBannedCommand;
import io.github.searchndstroy.customenchants.common.CustomEnchants;
import io.github.searchndstroy.customenchants.common.GetLoreString;
import io.github.searchndstroy.customenchants.common.GetSecondsOrAmplifier;
import io.github.searchndstroy.customenchants.common.RomanNumeralConverterToInt;

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
	
	private String secondstype = CustomEnchants.config.getString("regenweapon.TypeForSeconds");
	private int defaultseconds = CustomEnchants.config.getInt("regenweapon.defaultseconds");
	private String amplifiertype = CustomEnchants.config.getString("regenweapon.TypeForAmplifier");
	private int defaultamplifier = CustomEnchants.config.getInt("regenweapon.defaultamplifier");
	private int secondstoworkwith = CustomEnchants.config.getInt("regenweapon.secondstoworkwith");
	private int amplifiertoworkwith = CustomEnchants.config.getInt("regenweapon.amplifiertoworkwith");
	private int maxtierlevel = CustomEnchants.config.getInt("regenweapon.MaximumTierLevel");
	private String enchantmentname = "RegenWeapon";
	
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
		
		String string = GetLoreString.getLoreString(lore, maxtierlevel, enchantmentname);
		
		int tierlevel = RomanNumeralConverterToInt.romanToDecimal(string);
		
		if (tierlevel == 0)
			return;
		
		if (IsEnchantmentBannedCommand.isEnchantmentBanned(CustomEnchants.bannedenchants, CustomEnchants.enchantments, enchantmentname))
			return;
			
		int seconds = GetSecondsOrAmplifier.getSeconds(secondstype, defaultseconds, secondstoworkwith, tierlevel);
		int amplifier = GetSecondsOrAmplifier.getAmplifier(amplifiertype, defaultamplifier, amplifiertoworkwith, tierlevel);
		
		PotionEffect potion = new PotionEffect(PotionEffectType.REGENERATION, seconds, amplifier);
		player.addPotionEffect(potion);
			
	}

}
