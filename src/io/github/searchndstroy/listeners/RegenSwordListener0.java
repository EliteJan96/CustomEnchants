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

package io.github.searchndstroy.listeners;

import io.github.searchndstroy.Main;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RegenSwordListener0 implements Listener {

	Main plugin;

	public RegenSwordListener0(Main instance) {

		plugin = instance;

	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onEntityDamageByEntityEvent0(EntityDamageByEntityEvent event) {

		Entity attacker = (Entity) event.getDamager();
		Entity defender = (Entity) event.getEntity();
		int seconds0 = plugin.getCustomConfig().getInt("Regen.I.seconds");
		int seconds = seconds0 * 20;
		int amplifier0 = plugin.getCustomConfig().getInt("Regen.I.amplifier");
		int amplifier = amplifier0 - 1;

		if (attacker instanceof Player) {

			if (defender instanceof Player) {

				if (!((HumanEntity) attacker).getInventory().getItemInHand()
						.equals(null)
						|| ((HumanEntity) attacker).getInventory()
								.getItemInHand().equals(Material.AIR)) {

					if (((HumanEntity) attacker).getItemInHand().getItemMeta()
							.hasLore()) {

						if (((HumanEntity) attacker).getItemInHand()
								.getItemMeta().getLore().get(0)
								.equals("§r§7Regen I")) {

							((LivingEntity) attacker)
									.addPotionEffect(new PotionEffect(
											PotionEffectType.REGENERATION,
											seconds, amplifier));

						}
					}
				}
			}
		}
	}
}
