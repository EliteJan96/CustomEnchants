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

					if (args[1].equalsIgnoreCase("poison")) {

						List<String> derp01 = iteminhandim.getLore();

						String poison = "§r§7Poison";
						String poison1 = poison + " I";
						String poison2 = poison + " II";
						String poison3 = poison + " III";
						String poison4 = poison + " IV";
						String poison5 = poison + " V";

						if (iteminhandim.hasLore()) {

							if (derp01.contains(poison1)
									|| derp01.contains(poison2)
									|| derp01.contains(poison3)
									|| derp01.contains(poison4)
									|| derp01.contains(poison5)) {

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

								lore.add("§r§7Poison I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							} else {

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Poison I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							}

						}

						if (args[2].equalsIgnoreCase("2")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Poison II");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Poison II");

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

								lore.add("§r§7Poison III");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Poison III");

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

								lore.add("§r§7Poison IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Poison IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item");

							}

						}

						if (args[2].equalsIgnoreCase("5")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Poison V");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Poison V");

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

					if (args[1].equalsIgnoreCase("leechhunger")) {

						List<String> derp01 = iteminhandim.getLore();

						String leechhunger = "§r§7LeechHunger";
						String leechhunger1 = leechhunger + " I";
						String leechhunger2 = leechhunger + " II";
						String leechhunger3 = leechhunger + " III";
						String leechhunger4 = leechhunger + " IV";
						String leechhunger5 = leechhunger + " V";

						if (iteminhandim.hasLore()) {

							if (derp01.contains(leechhunger1)
									|| derp01.contains(leechhunger2)
									|| derp01.contains(leechhunger3)
									|| derp01.contains(leechhunger4)
									|| derp01.contains(leechhunger5)) {

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

								lore.add("§r§7Leechhunger I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							} else {

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								List<String> lore = new ArrayList<String>();

								lore.add("§r§Leechhunger I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							}

						}

						if (args[2].equalsIgnoreCase("2")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Leechhunger II");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Leechhunger II");

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

								lore.add("§r§7Leechhunger III");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Leechhunger III");

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

								lore.add("§r§7Leechhunger IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Leechhunger IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item");

							}

						}

						if (args[2].equalsIgnoreCase("5")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Leechhunger V");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Leechhunger V");

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

					if (args[1].equalsIgnoreCase("nausea")) {

						List<String> derp01 = iteminhandim.getLore();

						String nausea = "§r§7Nausea";
						String nausea1 = nausea + " I";
						String nausea2 = nausea + " II";
						String nausea3 = nausea + " III";
						String nausea4 = nausea + " IV";
						String nausea5 = nausea + " V";

						if (iteminhandim.hasLore()) {

							if (derp01.contains(nausea1)
									|| derp01.contains(nausea2)
									|| derp01.contains(nausea3)
									|| derp01.contains(nausea4)
									|| derp01.contains(nausea5)) {

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

								lore.add("§r§7Nausea I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							} else {

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								List<String> lore = new ArrayList<String>();

								lore.add("§r§Nausea I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							}

						}

						if (args[2].equalsIgnoreCase("2")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Nausea II");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Nausea II");

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

								lore.add("§r§7Nausea III");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Nausea III");

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

								lore.add("§r§7Nausea IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Nausea IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item");

							}

						}

						if (args[2].equalsIgnoreCase("5")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Nausea V");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Nausea V");

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

					if (args[1].equalsIgnoreCase("blind")) {

						List<String> derp01 = iteminhandim.getLore();

						String blind = "§r§7Blind";
						String blind1 = blind + " I";
						String blind2 = blind + " II";
						String blind3 = blind + " III";
						String blind4 = blind + " IV";
						String blind5 = blind + " V";

						if (iteminhandim.hasLore()) {

							if (derp01.contains(blind1)
									|| derp01.contains(blind2)
									|| derp01.contains(blind3)
									|| derp01.contains(blind4)
									|| derp01.contains(blind5)) {

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

								lore.add("§r§7Blind I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							} else {

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								List<String> lore = new ArrayList<String>();

								lore.add("§r§Blind I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							}

						}

						if (args[2].equalsIgnoreCase("2")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Blind II");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Blind II");

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

								lore.add("§r§7Blind III");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Blind III");

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

								lore.add("§r§7Blind IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Blind IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item");

							}

						}

						if (args[2].equalsIgnoreCase("5")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Blind V");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Blind V");

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

					if (args[1].equalsIgnoreCase("slow")) {

						List<String> derp01 = iteminhandim.getLore();

						String slow = "§r§7Slow";
						String slow1 = slow + " I";
						String slow2 = slow + " II";
						String slow3 = slow + " III";
						String slow4 = slow + " IV";
						String slow5 = slow + " V";

						if (iteminhandim.hasLore()) {

							if (derp01.contains(slow1)
									|| derp01.contains(slow2)
									|| derp01.contains(slow3)
									|| derp01.contains(slow4)
									|| derp01.contains(slow5)) {

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

								lore.add("§r§7Slowness I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							} else {

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								List<String> lore = new ArrayList<String>();

								lore.add("§r§Slowness I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							}

						}

						if (args[2].equalsIgnoreCase("2")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Slowness II");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Slowness II");

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

								lore.add("§r§7Slowness III");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Slowness III");

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

								lore.add("§r§7Slowness IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Slowness IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item");

							}

						}

						if (args[2].equalsIgnoreCase("5")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Slowness V");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Slowness V");

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

					if (args[1].equalsIgnoreCase("resistance")) {

						List<String> derp01 = iteminhandim.getLore();

						String resistance = "§r§7Slow";
						String resistance1 = resistance + " I";
						String resistance2 = resistance + " II";
						String resistance3 = resistance + " III";
						String resistance4 = resistance + " IV";
						String resistance5 = resistance + " V";

						if (iteminhandim.hasLore()) {

							if (derp01.contains(resistance1)
									|| derp01.contains(resistance2)
									|| derp01.contains(resistance3)
									|| derp01.contains(resistance4)
									|| derp01.contains(resistance5)) {

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

								lore.add("§r§7Resistance I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							} else {

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								List<String> lore = new ArrayList<String>();

								lore.add("§r§Resistance I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							}

						}

						if (args[2].equalsIgnoreCase("2")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Resistance II");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Resistance II");

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

								lore.add("§r§7Resistance III");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Resistance III");

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

								lore.add("§r§7Resistance IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Resistance IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item");

							}

						}

						if (args[2].equalsIgnoreCase("5")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Resistance V");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Resistance V");

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

					if (args[1].equalsIgnoreCase("speed")) {

						List<String> derp01 = iteminhandim.getLore();

						String speed = "§r§7Speed";
						String speed1 = speed + " I";
						String speed2 = speed + " II";
						String speed3 = speed + " III";
						String speed4 = speed + " IV";
						String speed5 = speed + " V";

						if (iteminhandim.hasLore()) {

							if (derp01.contains(speed1)
									|| derp01.contains(speed2)
									|| derp01.contains(speed3)
									|| derp01.contains(speed4)
									|| derp01.contains(speed5)) {

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

								lore.add("§r§7Speed I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							} else {

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								List<String> lore = new ArrayList<String>();

								lore.add("§r§Speed I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							}

						}

						if (args[2].equalsIgnoreCase("2")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Speed II");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Speed II");

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

								lore.add("§r§7Speed III");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Speed III");

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

								lore.add("§r§7Speed IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Speed IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item");

							}

						}

						if (args[2].equalsIgnoreCase("5")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Speed V");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Speed V");

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

					if (args[1].equalsIgnoreCase("invisibility")) {

						List<String> derp01 = iteminhandim.getLore();

						String invisibility = "§r§7Invisibility";
						String invisibility1 = invisibility + " I";
						String invisibility2 = invisibility + " II";
						String invisibility3 = invisibility + " III";
						String invisibility4 = invisibility + " IV";
						String invisibility5 = invisibility + " V";

						if (iteminhandim.hasLore()) {

							if (derp01.contains(invisibility1)
									|| derp01.contains(invisibility2)
									|| derp01.contains(invisibility3)
									|| derp01.contains(invisibility4)
									|| derp01.contains(invisibility5)) {

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

								lore.add("§r§7Invisibility I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							} else {

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								List<String> lore = new ArrayList<String>();

								lore.add("§r§Invisibility I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							}

						}

						if (args[2].equalsIgnoreCase("2")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Invisibility II");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Invisibility II");

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

								lore.add("§r§7Invisibility III");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Invisibility III");

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

								lore.add("§r§7Invisibility IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Invisibility IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item");

							}

						}

						if (args[2].equalsIgnoreCase("5")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Invisibility V");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Invisibility V");

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

					if (args[1].equalsIgnoreCase("strength")) {

						List<String> derp01 = iteminhandim.getLore();

						String strength = "§r§7Strength";
						String strength1 = strength + " I";
						String strength2 = strength + " II";
						String strength3 = strength + " III";
						String strength4 = strength + " IV";
						String strength5 = strength + " V";

						if (iteminhandim.hasLore()) {

							if (derp01.contains(strength1)
									|| derp01.contains(strength2)
									|| derp01.contains(strength3)
									|| derp01.contains(strength4)
									|| derp01.contains(strength5)) {

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

								lore.add("§r§7Strength I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							} else {

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								List<String> lore = new ArrayList<String>();

								lore.add("§r§Strength I");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								return true;

							}

						}

						if (args[2].equalsIgnoreCase("2")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Strength II");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Strength II");

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

								lore.add("§r§7Strength III");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

								return true;

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Strength III");

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

								lore.add("§r§7Strength IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Strength IV");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item");

							}

						}

						if (args[2].equalsIgnoreCase("5")) {

							if (iteminhandim.hasLore() == true) {

								List<String> lore = iteminhandim.getLore();

								lore.add("§r§7Strength V");

								iteminhandim.setLore(lore);

								iteminhand.setItemMeta(iteminhandim);

								sender.sendMessage(ChatColor.GREEN
										+ "Successfully enchanted your item!");

							} else {

								List<String> lore = new ArrayList<String>();

								lore.add("§r§7Strength V");

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