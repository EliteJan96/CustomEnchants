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


package io.github.searchndstroy.customenchants.common;

import io.github.searchndstroy.customenchants.commands.CustomEnchantsCommand;
import io.github.searchndstroy.customenchants.commands.IsEnchantmentBannedCommand;
import io.github.searchndstroy.customenchants.listeners.ExtremeKnockbackArrowListener;
import io.github.searchndstroy.customenchants.listeners.FishingTestListener;
import io.github.searchndstroy.customenchants.listeners.RegenEnchantWeaponListener;
import io.github.searchndstroy.customenchants.listeners.SignBreakListener;
import io.github.searchndstroy.customenchants.listeners.SignInteractListener;
import io.github.searchndstroy.customenchants.listeners.SignPlaceListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

public class CustomEnchants extends JavaPlugin {

	public final Logger logger = this.getLogger();
	public static final Level info = Level.INFO;
	public static final Level severe = Level.SEVERE;
	
	public static FileConfiguration config;
	
	public static List<String> enchantments = new ArrayList<String>();
	public static List<String> bannedenchants = new ArrayList<String>();
	
    public static Economy economy = null;
    public static Permission permission = null;

    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }
    
    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }

	
	private final void eventRegister() {
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new RegenEnchantWeaponListener(), this);
		pm.registerEvents(new ExtremeKnockbackArrowListener() , this);
		if (!setupEconomy() || !setupPermissions()) {
			
			logger.log(severe, "Vault/Permission plugin not found! Not registering certain features! You need Vault and a permissions plugin!!");
		} else {
			
			pm.registerEvents(new FishingTestListener(), this);
			pm.registerEvents(new SignInteractListener(), this);
			pm.registerEvents(new SignPlaceListener(), this);
			pm.registerEvents(new SignBreakListener(), this);
		}
	}
	
	private final void commandRegister() {
		
		getCommand("customenchants").setExecutor(new CustomEnchantsCommand());
		getCommand("isenchantbanned").setExecutor(new IsEnchantmentBannedCommand());
		getCommand("reloadcustomenchants").setExecutor(new ReloadConfigCommand());
	}
	
	private final void registerOtherOnLoad() {
		enchantments.add(0, "RegenWeapon");
		enchantments.add(1, "");
		
	}
	
	@Override
	public void onLoad() {
		config = getConfig();
		registerOtherOnLoad();
	}
	@Override
	public void onEnable() {
		
		eventRegister();
		commandRegister();

		logger.log(info, "Plugin enabled! Have fun! :D");
		logger.log(info, "You are running a dev version! THIS IS NOT A COMPLETE VERSION, IT IS UNFINISHED.");
		saveDefaultConfig();

		try {

			Metrics metrics = new Metrics(this);
			metrics.start();

		} catch (IOException e) {

			logger.log(severe, "Failed to start metrics!");

		}

	}

	@Override
	public void onDisable() {

		logger.log(info, "Plugin disabled! Hope you had fun! :D");

	}

}
