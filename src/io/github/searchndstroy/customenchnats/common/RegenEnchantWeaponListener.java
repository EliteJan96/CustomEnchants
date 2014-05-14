package io.github.searchndstroy.customenchnats.common;

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
		
		if (im.getLore().contains(ChatColor.RED + "Regen I")) {
			
			
		}
	}

}
