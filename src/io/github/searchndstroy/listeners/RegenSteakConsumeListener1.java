package io.github.searchndstroy.listeners;

import io.github.searchndstroy.Main;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RegenSteakConsumeListener1 implements Listener {
	
	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onPlayerItemConsume(PlayerItemConsumeEvent e) {
		
		int seconds = Main.config.getInt("RegenFood.II.seconds");
		int amplifier = Main.config.getInt("RegenFood.II.amplifier");
		
		HumanEntity player = e.getPlayer();
		
		ItemStack food = e.getItem();
		ItemMeta foodim = food.getItemMeta();
		
		if (player instanceof Player) {
			
			if (foodim.hasLore()) {
				
				if (foodim.getLore().contains("§r§7RegenFood II")) {
					
					player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, seconds, amplifier));
					
				}
				
			}
			
		} else
			return;
			

	}

}
