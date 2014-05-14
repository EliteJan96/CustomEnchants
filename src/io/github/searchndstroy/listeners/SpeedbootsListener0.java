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

import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpeedbootsListener0 implements Listener {

	Main plugin;

	public SpeedbootsListener0(Main instance) {

		plugin = instance;

	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onPlayerMoveEvent1(PlayerMoveEvent event) {

		Entity player = event.getPlayer();
		int seconds0 = plugin.getCustomConfig().getInt("Speed.II.seconds");
		int seconds = seconds0 * 20;
		int amplifier0 = plugin.getCustomConfig().getInt("Speed.I.amplifier");
		int amplifier = amplifier0 - 1;
		

		ItemStack[] armour = ((Player) player).getInventory()
				.getArmorContents();

		if (player instanceof Player) {


			if (armour == null || armour.length == 0) {
				return;

		} else {
			
			Item

			if () {

				if (((HumanEntity) player).getInventory().getBoots()
						.getItemMeta().getLore().contains("§r§7Speed I")) {

					((HumanEntity) player).addPotionEffect(new PotionEffect(
							PotionEffectType.SPEED, seconds, amplifier));

				}
			}
		}
		}
	}
}
