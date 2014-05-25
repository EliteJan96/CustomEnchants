package io.github.searchndstroy.customenchants.common;

import io.github.searchndstroy.customenchants.listeners.FishingTestListener;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SignInteractListener implements Listener {
	
	@EventHandler(ignoreCancelled = true)
	public void onPlayerInteract(PlayerInteractEvent e) {
		
		Block block = e.getClickedBlock();
		Player player = e.getPlayer();
		String playername = player.getName();
		
		if (block.getType() == Material.SIGN_POST || block.getType() == Material.WALL_SIGN) {
		
			Sign sign = (Sign) block.getState();
			String line0 = sign.getLine(0);

			if (line0.isEmpty() || !line0.equalsIgnoreCase("[enchantsign]"))
				return;

			String line1 = sign.getLine(1);
			
			if (!CustomEnchants.enchantments.contains(line1) || line1.isEmpty())
				return;
			
			ItemStack itemstack = player.getInventory().getItemInHand();
			ItemMeta itemmeta = itemstack.getItemMeta();
			List<String> lore;
			
			if (itemstack == null || itemstack.getType().equals(Material.AIR))
				return;
			
			if (itemmeta.getLore() == null || itemmeta.getLore().isEmpty()) {
				
				lore = new ArrayList<String>();
				
			} else {
				lore = itemmeta.getLore();
			}
			
			String line2 = sign.getLine(2);
			
			int tierlevel;
			
			boolean itemhasenchant;
			double cost;
			
			try {
				
				cost = Double.parseDouble(line2);
				String line3 = sign.getLine(3);
				tierlevel = Integer.parseInt(line3);
				itemhasenchant = AddEnchant.ItemHasCurrentEnchant(itemmeta, lore, line1);
			}
			
			catch (NumberFormatException ex) {
				return;
			}
			
			if (itemhasenchant)
				return;
			
			double playerbalance = CustomEnchants.economy.getBalance(playername);
			
			if (playerbalance < cost) {
				player.sendMessage(ChatColor.RED + "You do not have enough balance for this enchantment!");
				return;
			}
			
			System.out.println("Test1");
			
			String currencysymbol = CustomEnchants.config.getString("other.currencysymbol");
			String currencysymbolpos = CustomEnchants.config.getString("other.sidecurrencygoeson");
			String coststring = FishingTestListener.objectToString(cost);
			String stringcost;
			if (currencysymbolpos.equalsIgnoreCase("left"))
				stringcost = currencysymbol + coststring;	
			else if(currencysymbolpos.equalsIgnoreCase("right"))
				stringcost = coststring + currencysymbol;
			else
				stringcost = coststring;
			
			CustomEnchants.economy.withdrawPlayer(playername, cost);
			
			CustomEnchants.getPlugin(CustomEnchants.class).logger.log(Level.INFO, "Player " + playername + " bought " + line1 + " " + tierlevel + " for " + stringcost);
			player.sendMessage(ChatColor.YELLOW + "You payed " + stringcost + " for " + line1 + " " + tierlevel + "!");
			AddEnchant.AddEnchantToItem(line1, itemstack, itemmeta, lore, player, tierlevel, false);
		}

	}
}
