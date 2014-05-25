package io.github.searchndstroy.customenchants.common;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class SignPlaceListener implements Listener {
	
	@EventHandler(ignoreCancelled = true)
	public void onBlockPlace(BlockPlaceEvent e) {

		Block block = e.getBlock();
		
		if (!block.equals(Material.WALL_SIGN) || !block.equals(Material.SIGN_POST))
			return;
		
		String line0 = ((Sign) block).getLine(0);
		
		if (!line0.equalsIgnoreCase("[enchantsign]"))
			return;
		
		Player player = e.getPlayer();
		
		System.out.println("Test!");
		
		if (player.hasPermission("customenchants.signshop.place") || player.isOp())
			return;
		
		System.out.println("TEst2");
		
		e.setCancelled(true);
		
		player.sendMessage(ChatColor.RED + "You are not allowed to place CE sign shops!");
		
		
	}

}
