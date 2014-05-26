package io.github.searchndstroy.customenchants.listeners;

import io.github.searchndstroy.customenchants.common.CustomEnchants;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class SignBreakListener implements Listener {
	
	private String permission;

	@EventHandler(ignoreCancelled = true)
	public void onBlockBreak(BlockBreakEvent e) {
		
		permission = "customenchants.signshop.break";
		
		Block block = e.getBlock();
		Player player = e.getPlayer();
		
		if (!(block.getState() instanceof Sign))
			return;
		
		if (block.getType() == Material.SIGN_POST || block.getType() == Material.WALL_SIGN) {
			
			Sign sign = (Sign)e.getBlock().getState();
			String line0 = sign.getLine(0);
			
			if (line0.equalsIgnoreCase("[enchantsign]") && !CustomEnchants.permission.has(player, permission)) {
				
				player.sendMessage(ChatColor.RED + "You need the permission node " + permission + "  to break this sign!");
				e.setCancelled(true);
				
			}

		}
	}

}
