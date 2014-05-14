package io.github.searchndstroy.customenchnats.common;

import io.github.searchndstroy.customenchnats.commands.CustomEnchantsCommand;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

public class CustomEnchants extends JavaPlugin {

	public final Logger logger = this.getLogger();
	public static final Level info = Level.INFO;
	public static final Level severe = Level.SEVERE;

	public void onEnable() {

		logger.log(info, "Plugin enabled! Have fun! :D");
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new RegenEnchantWeaponListener(), this);

		getCommand("customenchants").setExecutor(new CustomEnchantsCommand());

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
