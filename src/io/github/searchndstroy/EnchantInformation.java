package io.github.searchndstroy;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class EnchantInformation implements CommandExecutor {

	Main plugin;

	public EnchantInformation(Main instance) {

		plugin = instance;

	}

	private void InvGUI(Player player) {
		
		FileConfiguration config = Main.config;

		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.AQUA
				+ "Enchantment Information!");

		ItemStack book0 = new ItemStack(Material.WRITTEN_BOOK);
		ItemStack book1 = new ItemStack(Material.WRITTEN_BOOK);

		BookMeta meta0 = (BookMeta) book0.getItemMeta();
		BookMeta meta1 = (BookMeta) book1.getItemMeta();
		
		int seconds0 = config.getInt("Regen.I.seconds");
		int amplifier0 = config.getInt("Regen.I.amplifier");
		
		meta0.setTitle(ChatColor.RED + "Regen Enchant");
		meta0.setAuthor("searchndstroy");
		
		List<String> pages0 = new ArrayList<String>();
		
		pages0.set(1, "Introduction");
		pages0.set(2, "Tier 1");
		pages0.set(3, "Tier 2");
		pages0.set(4, "Tier 3");
		pages0.set(5, "Tier 4");
		pages0.set(6, "Tier 6");
		
		pages0.add("This enchantment gives you health when you hit a player. "
				+ "It will not give you health if you attack a mob. "
				+ "There are five tiers to this enchantment.");
		pages0.add("The duration of this effect is " + seconds0 + ". Or " + seconds0 * 20
				+ " ticks." + " Also the amplifier of the effect is " + amplifier0);
		meta0.setPages(pages0);
		book0.setItemMeta(meta0);

		player.openInventory(inv);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String cmdlabel, String[] args) {

		if (!(sender instanceof Player)) {

			sender.sendMessage("You cannot run this command as console!");

			return false;
		} else {

			if (cmdlabel.equalsIgnoreCase("enchantinformation")
					|| cmdlabel.equalsIgnoreCase("ei")) {

				Player player = (Player) sender;

				InvGUI(player);

				return true;
			}
		}

		return false;

	}

}