package io.github.searchndstroy.customenchants.listeners;

import io.github.searchndstroy.customenchants.common.AddEnchant;
import io.github.searchndstroy.customenchants.common.CustomEnchants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SignInteractListener implements Listener {
	
	private String permission;
	
	@EventHandler(ignoreCancelled = true)
	public void onPlayerInteract(PlayerInteractEvent e) {
		
		Action action = e.getAction();
		
		permission = "customenchants.signshop.use";
		
		if (!action.equals(Action.RIGHT_CLICK_BLOCK))
			return;
		
		Block block = e.getClickedBlock();
		Player player = e.getPlayer();
		String playername = player.getName();
		
		if (block instanceof Sign)
			return;

		Sign sign = (Sign) block.getState();
		List<String> lines = Arrays.asList(sign.getLines());

		String line0 = lines.get(0);

		if (line0.isEmpty() || !line0.equalsIgnoreCase("[enchantsign]"))
			return;
		
		if (!CustomEnchants.permission.has(player, permission)) {

			player.sendMessage(ChatColor.RED
					+ "You need to have customenchants.signshop.use to buy enchantments off signs!");
			return;
		}

		String line1 = lines.get(1);

		if (!CustomEnchants.enchantments.contains(line1) || line1.isEmpty())
			return;

		ItemStack itemstack = player.getInventory().getItemInHand();
		ItemMeta itemmeta = itemstack.getItemMeta();
		List<String> lore;

		if (itemstack == null || itemstack.getType().equals(Material.AIR)) {

			player.sendMessage(ChatColor.RED
					+ "Have a valid item in your hand!");
			return;
		}

		if (itemmeta.getLore() == null || itemmeta.getLore().isEmpty()) {

			lore = new ArrayList<String>();

		} else {
			lore = itemmeta.getLore();
		}

		String line2 = lines.get(2);

		int tierlevel;

		boolean itemhasenchant;
		double cost;

		try {

			cost = Double.parseDouble(line2);
			String line3 = lines.get(3);
			tierlevel = Integer.parseInt(line3);
			itemhasenchant = AddEnchant.ItemHasCurrentEnchant(itemmeta, lore,
					line1);
		}

		catch (NumberFormatException ex) {
			return;
		}

		if (itemhasenchant) {

			player.sendMessage("You already have this enchantment on your item!");
			return;
		}

		double playerbalance = CustomEnchants.economy.getBalance(player);

		if (playerbalance < cost) {
			player.sendMessage(ChatColor.RED
					+ "You do not have enough balance for this enchantment!");
			return;
		}

		String currencysymbol = "$";
		String currencysymbolpos = CustomEnchants.config.getString("other.sidecurrencygoeson");
		String coststring = FishingTestListener.objectToString(cost);
		String stringcost;
		if (currencysymbolpos.equalsIgnoreCase("left"))
			stringcost = currencysymbol + coststring;
		else if (currencysymbolpos.equalsIgnoreCase("right"))
			stringcost = coststring + currencysymbol;
		else
			stringcost = coststring;

		CustomEnchants.economy.withdrawPlayer(player, cost);

		CustomEnchants.getPlugin(CustomEnchants.class).logger.log(Level.INFO, "Player " + playername + " bought " + line1 + " " + tierlevel + " for " + stringcost);
		player.sendMessage(ChatColor.YELLOW + "You payed " + stringcost	+ " for " + line1 + " " + tierlevel + "!");
		AddEnchant.AddEnchantToItem(line1, itemstack, itemmeta, lore, player,tierlevel, false);
	}

}
