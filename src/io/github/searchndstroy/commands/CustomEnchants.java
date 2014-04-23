package io.github.searchndstroy.commands;

import io.github.searchndstroy.Main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomEnchants implements CommandExecutor {
	private Main plugin;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		if (label.equalsIgnoreCase("ce") || label.equalsIgnoreCase("customenchants")) {
			
			if (!(sender instanceof Player)) {
				
				sender.sendMessage("Please run this command as a logged-in user!");
				int i = this.plugin.getCustomConfig().getInt("Regen.I.seconds");
				System.out.println(i);
				
			} else {
				
				Player player = (Player) sender;
				
				if (args.length == 0) {
					
					sender.sendMessage(ChatColor.RED + "Please use three arguments, not zero!");
					sender.sendMessage(ChatColor.RED + "Usage: /ce enchant <enchantname> <tier>");
					
					return false;
				}
				
				if (args.length == 1 && args[0].equalsIgnoreCase("enchant")) {
					
					sender.sendMessage("Please use three arguments, not one!");
					sender.sendMessage(ChatColor.RED + "Usage: /ce enchant <enchantname> <tier>");
					
					return false;
				}
				
				if (args.length == 2) {
					
					sender.sendMessage(ChatColor.RED + "Please use three arguments, not two!");
					sender.sendMessage(ChatColor.RED + "Usage: /ce enchant <enchantname> <tier>");
					
					return false;
				}
				
				if (args.length > 3) {
					
					sender.sendMessage(ChatColor.RED + "Please use three arguments, not " + args.length + "!");
					sender.sendMessage(ChatColor.RED + "Usage: /ce enchant <enchantname> <tier>");
					
					return false;
				}
				
				ItemStack iteminhand = player.getInventory().getItemInHand();
				
				if (iteminhand != null) {
					
					if (args[0].equalsIgnoreCase("reload")) {
						
						//this.plugin.reloadCustomConfig();
						//this.plugin.getCustomConfig();
						
						return false;
					} else if (args[0].equalsIgnoreCase("enchant")) {
					
					if (args[1].equalsIgnoreCase("regen")) {
						
						if (args[2].equalsIgnoreCase("1")) {
							
							ItemMeta im0 = iteminhand.getItemMeta();
							List<String> lore0 = new ArrayList<String>();
							lore0.add("§r§7Regen I");
							if (im0.hasLore()) {
								
								if (im0.getLore().contains("Regen")) {
									
								} else {
								
								lore0.addAll(im0.getLore());
								im0.setLore(lore0);
								iteminhand.setItemMeta(im0);
								
								return false;
							}
							
							return false;
						} else if (args[2].equalsIgnoreCase("2")) {
							
							ItemMeta im1 = iteminhand.getItemMeta();
							List<String> lore1 = new ArrayList<String>();
							lore1.add("§r§7Regen II");
							if (im1.hasLore()) {
								
								lore1.addAll(im1.getLore());
								im1.setLore(lore1);
								iteminhand.setItemMeta(im1);
								
								return false;
							} else {
								
								im1.setLore(lore1);
								iteminhand.setItemMeta(im1);
							}
							
							return false;
						} else if (args[2].equalsIgnoreCase("3")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("4")) {
							
							return false;
						} else if (args[3].equalsIgnoreCase("5")) {
							
							return false;
						}
						
						return false;
					} else if (args[1].equalsIgnoreCase("poison")) {
						
						if (args[2].equalsIgnoreCase("1")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("2")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("3")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("4")) {
							
							return false;
						} else if (args[3].equalsIgnoreCase("5")) {
							
							return false;
						}
						
						return false;
					} else if (args[1].equalsIgnoreCase("wither")) {
						
						if (args[2].equalsIgnoreCase("1")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("2")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("3")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("4")) {
							
							return false;
						} else if (args[3].equalsIgnoreCase("5")) {
							
							return false;
						}
						
						return false;
					} else if (args[1].equalsIgnoreCase("blind")) {
						
						if (args[2].equalsIgnoreCase("1")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("2")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("3")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("4")) {
							
							return false;
						} else if (args[3].equalsIgnoreCase("5")) {
							
							return false;
						}
						
						return false;
					} else if (args[1].equalsIgnoreCase("leechhunger")) {
						
						if (args[2].equalsIgnoreCase("1")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("2")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("3")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("4")) {
							
							return false;
						} else if (args[3].equalsIgnoreCase("5")) {
							
							return false;
						}
						
						return false;
					} else if (args[1].equalsIgnoreCase("nausea")) {
						
						if (args[2].equalsIgnoreCase("1")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("2")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("3")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("4")) {
							
							return false;
						} else if (args[3].equalsIgnoreCase("5")) {
							
							return false;
						}
						
						return false;
					} else if (args[1].equalsIgnoreCase("resistance")) {
						
						if (args[2].equalsIgnoreCase("1")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("2")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("3")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("4")) {
							
							return false;
						} else if (args[3].equalsIgnoreCase("5")) {
							
							return false;
						}
						
						return false;
					} else if (args[1].equalsIgnoreCase("strength")) {
						
						if (args[2].equalsIgnoreCase("1")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("2")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("3")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("4")) {
							
							return false;
						} else if (args[3].equalsIgnoreCase("5")) {
							
							return false;
						}
						
						return false;
					} else if (args[1].equalsIgnoreCase("slow")) {
						
						if (args[2].equalsIgnoreCase("1")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("2")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("3")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("4")) {
							
							return false;
						} else if (args[3].equalsIgnoreCase("5")) {
							
							return false;
						}
						
						return false;
					} else if (args[1].equalsIgnoreCase("speed")) {
						
						if (args[2].equalsIgnoreCase("1")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("2")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("3")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("4")) {
							
							return false;
						} else if (args[3].equalsIgnoreCase("5")) {
							
							return false;
						}
						
						return false;
					} else if (args[1].equalsIgnoreCase("invisibility")) {
						
						if (args[2].equalsIgnoreCase("1")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("2")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("3")) {
							
							return false;
						} else if (args[2].equalsIgnoreCase("4")) {
							
							return false;
						} else if (args[3].equalsIgnoreCase("5")) {
							
							return false;
						}
						
						return false;
					}
					
					return false;
				}
			     return false;
				} else {
					
					sender.sendMessage(ChatColor.RED + "Have a valid item in your hand!");
					
				}
				
				return false;
			}
			
			return false;
		}
		
		
		
		}
		
				return false;
	} // End of onCommand
} // End of file