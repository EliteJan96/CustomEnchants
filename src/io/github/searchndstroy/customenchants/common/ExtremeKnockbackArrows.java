package io.github.searchndstroy.customenchants.common;

import java.util.List;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ExtremeKnockbackArrows implements Listener {
	
	@EventHandler(ignoreCancelled = true)
	public void onEntityShootBowEvent(EntityShootBowEvent e) {
		
		Entity entity = e.getEntity();
		ItemStack bow = e.getBow();
	    Entity entityproj = e.getProjectile();
		
		if (!(entityproj instanceof Projectile))
			return;
		
		if (!(entity instanceof Player))
			return;
		
		Projectile proj = (Projectile) entityproj;
		ItemMeta bowim = bow.getItemMeta();
		
		if (!bowim.hasLore())
			return;
		
		List<String> lore = bowim.getLore();
		
		if (lore != null && proj instanceof Arrow && lore.contains("ExtremeKnockback")) {
			
			Arrow arrowproj = (Arrow) proj;
			
			int strength = arrowproj.getKnockbackStrength();
			
			arrowproj.setKnockbackStrength(strength * 2);
			
		}
		
	}

}
