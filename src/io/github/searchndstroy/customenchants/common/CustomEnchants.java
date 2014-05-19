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


package io.github.searchndstroy.customenchnats.common;

import io.github.searchndstroy.customenchnats.commands.CustomEnchantsCommand;
import io.github.searchndstroy.customenchnats.listeners.RegenEnchantWeaponListener;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

public class CustomEnchants extends JavaPlugin {

	public final Logger logger = this.getLogger();
	public static final Level info = Level.INFO;
	public static final Level severe = Level.SEVERE;
	
	public static FileConfiguration config;
	
	public final void eventRegister() {
		
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new RegenEnchantWeaponListener(), this);
		
	}
	
	public final void commandRegister() {
		
		getCommand("customenchants").setExecutor(new CustomEnchantsCommand());
		
	}
	
	public void onEnable() {
		
		eventRegister();
		commandRegister();
		
		config = getConfig();

		logger.log(info, "Plugin enabled! Have fun! :D");

		try {

			Metrics metrics = new Metrics(this);
			metrics.start();

		} catch (IOException e) {

			logger.log(severe, "Failed to start metrics!");

		}

	}

	public void onDisable() {

		logger.log(info, "Plugin disabled! Hope you had fun! :D");

	}

}