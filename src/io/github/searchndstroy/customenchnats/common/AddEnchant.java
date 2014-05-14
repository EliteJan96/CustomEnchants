package io.github.searchndstroy.customenchnats.common;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class AddEnchant {

	public static void AddEnchantToItem(AddEnchantType type, ItemStack itemstack, Player player) {

		if (ItemHasCurrentEnchant(itemstack))
			return;
		
		switch(type) {
		
		case REGENFOOD:
			break;
		
		default:
			break;
		}

	}

	public static boolean ItemHasCurrentEnchant(ItemStack itemstack) {

		return false;

	}
}
