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

package io.github.searchndstroy.commands;

import io.github.searchndstroy.Main;

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
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class EnchantInformation implements CommandExecutor, Listener {

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
		int seconds1 = config.getInt("Regen.II.seconds");
		int amplifier1 = config.getInt("Regen.II.amplifier");
		int seconds2 = config.getInt("Regen.III.seconds");
		int amplifier2 = config.getInt("Regen.III.amplifier");
		int seconds3 = config.getInt("Regen.IV.seconds");
		int amplifier3 = config.getInt("Regen.IV.amplifier");
		int seconds4 = config.getInt("Regen.V.seconds");
		int amplifier4 = config.getInt("Regen.V.amplifier");

		meta0.setDisplayName("Enchantment: Regen");
		meta1.setDisplayName("Enchantment: Poison");

		meta0.setTitle(ChatColor.RED + "Regen Enchant");
		meta1.setTitle(ChatColor.GREEN + "Poison Enchant");

		meta1.setAuthor("searchndstroy");
		meta0.setAuthor("searchndstroy");

		List<String> pages0 = new ArrayList<String>();
		List<String> pages1 = new ArrayList<String>();

		pages0.add("This enchantment gives you health when you hit a player. "
				+ "It will not give you health if you attack a mob. "
				+ "There are five tiers to this enchantment.");
		pages0.add("The duration of this effect is " + seconds0 + ". Or "
				+ seconds0 * 20 + " ticks."
				+ " Also the amplifier of the effect is " + amplifier0);
		pages0.add("The duration of this effect is " + seconds1 + ". Or "
				+ seconds1 * 20 + " ticks."
				+ " Also the amplifier of the effect is " + amplifier1);
		pages0.add("The duration of this effect is " + seconds2 + ". Or "
				+ seconds2 * 20 + " ticks."
				+ " Also the amplifier of the effect is " + amplifier2);
		pages0.add("The duration of this effect is " + seconds3 + ". Or "
				+ seconds3 * 20 + " ticks."
				+ " Also the amplifier of the effect is " + amplifier3);
		pages0.add("The duration of this effect is " + seconds4 + ". Or "
				+ seconds4 * 20 + " ticks."
				+ " Also the amplifier of the effect is " + amplifier4);
		

		meta0.setPages(pages0);
		meta1.setPages(pages1);

		book0.setItemMeta(meta0);
		book1.setItemMeta(meta1);

		inv.setItem(1, book0);
		inv.setItem(2, book1);

		player.openInventory(inv);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String cmdlabel, String[] args) {

		if (!(sender instanceof Player)) {

			sender.sendMessage("You cannot run this command as console!");

			return false;
		} else {

			if (!(args.length == 0)) {

				System.out.println("test");

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

}