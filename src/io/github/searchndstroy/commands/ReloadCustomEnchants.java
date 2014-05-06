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

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCustomEnchants implements CommandExecutor {

	Main plugin;

	public ReloadCustomEnchants(Main instance) {

		plugin = instance;

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String cmdlabel, String[] args) {
		
		if (args.length > 0) {
			
			sender.sendMessage("You don't need any arguments for this command!");
			
			return false;
		}

		if (cmdlabel.equalsIgnoreCase("reloadcustomenchants")
				|| cmdlabel.equalsIgnoreCase("rce")) {
			
			plugin.reloadCustomConfig();
			sender.sendMessage(ChatColor.GREEN + "Config reloaded!");

			return true;
		}

		return false;
	}
}
