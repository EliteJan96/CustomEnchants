package io.github.searchndstroy.customenchants.listeners;

import io.github.searchndstroy.customenchants.common.CustomEnchants;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignPlaceListener implements Listener {
	
	private String permission;
	
	@EventHandler(ignoreCancelled = true)
	public void onSignChange(SignChangeEvent e) {
		
		Player player = e.getPlayer();
		
		permission = "customenchants.signshop.place";
		
		List<String> lines = Arrays.asList(e.getLines());
		
		String line0 = lines.get(0);
		
		if (!line0.equalsIgnoreCase("[enchantsign]"))
			return;
		
		if (CustomEnchants.permission.has(player, permission))
			return;
		
		e.setCancelled(true);
		player.sendMessage(ChatColor.RED + "You do not have permission to place enchantsigns!");
	}

}
