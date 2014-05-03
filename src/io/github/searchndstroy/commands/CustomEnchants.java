package io.github.searchndstroy.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomEnchants implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String cmdlabel, String[] args) {

		if (!(sender instanceof Player)) {

			sender.sendMessage("You can only run this command as a player!");

		} else {

			String usage = ChatColor.RED
					+ "/customenchants enchant <enchantment name> <tier>";

			if (args.length <= 2) {

				sender.sendMessage("Please use three arguments, not "
						+ args.length);
				sender.sendMessage(usage);
				return false;
			}

			if (args.length > 3) {

				sender.sendMessage("Please use three arguments, not "
						+ args.length);
				sender.sendMessage(usage);
				return false;
			}

			Player player = (Player) sender;
			ItemStack iteminhand = player.getInventory().getItemInHand();
			ItemMeta iteminhandim = iteminhand.getItemMeta();

			if (iteminhand.getType() == null
					|| iteminhand.getType() == Material.AIR) {

				sender.sendMessage(ChatColor.RED
						+ "You have to have a valid item in your hand!");
				return false;

			} else if (cmdlabel.equalsIgnoreCase("customenchants")
					|| cmdlabel.equalsIgnoreCase("ce")) {

				if (args[0].equalsIgnoreCase("enchant")) {

					if (args[1].equalsIgnoreCase("regen")) {

						List<String> derp01 = iteminhandim.getLore();

						String regen = "§r§7Regen";
						String regen1 = regen + " I";
						String regen2 = regen + " II";
						String regen3 = regen + " III";
						String regen4 = regen + " IV";
						String regen5 = regen + " V";

						if (iteminhandim.hasLore()) {

							if (derp01.contains(regen1)
									|| derp01.contains(regen2)
									|| derp01.contains(regen3)
									|| derp01.contains(regen4)
									|| derp01.contains(regen5)) {

								sender.sendMessage(ChatColor.RED
										+ "You cannot have the same enchantment twice on a item!");

								return false;
							}

							// Start testing for input here(kinda)

						}

						if (args[2].equalsIgnoreCase("1")) {

							sender.sendMessage(ChatColor.GREEN
									+ "Successfully enchanted your item!");

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Regen I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							} else {

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Regen I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							}

						}

						if (args[2].equalsIgnoreCase("2")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Regen II");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Regen II");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							}

						}

						if (args[2].equalsIgnoreCase("3")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Regen III");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Regen III");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							}

						}

						if (args[2].equalsIgnoreCase("4")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Regen IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Regen IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item");

							}

						}

						if (args[2].equalsIgnoreCase("5")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Regen V");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Regen V");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item");

							}

						} else {

							sender.sendMessage(ChatColor.RED
									+ "Please put in a number from 1-5! Not "
									+ args[2]);

						}

						return false; // Not here
					}

					if (args[1].equalsIgnoreCase("wither")) {

						List<String> derp01 = iteminhandim.getLore();

						String wither = "§r§7Wither";
						String wither1 = wither + " I";
						String wither2 = wither + " II";
						String wither3 = wither + " III";
						String wither4 = wither + " IV";
						String wither5 = wither + " V";

						if (iteminhandim.hasLore()) {

							if (derp01.contains(wither1)
									|| derp01.contains(wither2)
									|| derp01.contains(wither3)
									|| derp01.contains(wither4)
									|| derp01.contains(wither5)) {

								sender.sendMessage(ChatColor.RED
										+ "You cannot have the same enchantment twice on a item!");

								return false;
							}

							// Start testing for input here(kinda)

						}

						if (args[2].equalsIgnoreCase("1")) {

							sender.sendMessage(ChatColor.GREEN
									+ "Successfully enchanted your item!");

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Wither I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							} else {

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Wither I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							}

						}

						if (args[2].equalsIgnoreCase("2")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Wither II");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Wither II");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							}

						}

						if (args[2].equalsIgnoreCase("3")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Wither III");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Wither III");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							}

						}

						if (args[2].equalsIgnoreCase("4")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Wither IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Wither IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item");

							}

						}

						if (args[2].equalsIgnoreCase("5")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Wither V");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Wither V");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item");

							}

						} else {

							sender.sendMessage(ChatColor.RED
									+ "Please put in a number from 1-5! Not "
									+ args[2]);

						}

						return false; // Not here
					}

					return false;
				}

				return false;
			}

		}

		return false;
	}
}