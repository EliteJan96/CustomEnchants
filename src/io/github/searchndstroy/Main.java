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

package io.github.searchndstroy;

import io.github.searchndstroy.commands.CustomEnchants;
import io.github.searchndstroy.commands.ReloadCustomEnchants;
import io.github.searchndstroy.listeners.BlindswordListener0;
import io.github.searchndstroy.listeners.BlindswordListener1;
import io.github.searchndstroy.listeners.BlindswordListener2;
import io.github.searchndstroy.listeners.BlindswordListener3;
import io.github.searchndstroy.listeners.BlindswordListener4;
import io.github.searchndstroy.listeners.InvisibilityswordListener0;
import io.github.searchndstroy.listeners.InvisibilityswordListener1;
import io.github.searchndstroy.listeners.InvisibilityswordListener2;
import io.github.searchndstroy.listeners.InvisibilityswordListener3;
import io.github.searchndstroy.listeners.InvisibilityswordListener4;
import io.github.searchndstroy.listeners.LeechHungerswordListener0;
import io.github.searchndstroy.listeners.LeechHungerswordListener1;
import io.github.searchndstroy.listeners.LeechHungerswordListener2;
import io.github.searchndstroy.listeners.LeechHungerswordListener3;
import io.github.searchndstroy.listeners.LeechHungerswordListener4;
import io.github.searchndstroy.listeners.NauseaswordListener0;
import io.github.searchndstroy.listeners.NauseaswordListener1;
import io.github.searchndstroy.listeners.NauseaswordListener2;
import io.github.searchndstroy.listeners.NauseaswordListener3;
import io.github.searchndstroy.listeners.NauseaswordListener4;
import io.github.searchndstroy.listeners.PoisonSwordListener0;
import io.github.searchndstroy.listeners.PoisonSwordListener1;
import io.github.searchndstroy.listeners.PoisonSwordListener2;
import io.github.searchndstroy.listeners.PoisonSwordListener3;
import io.github.searchndstroy.listeners.PoisonSwordListener4;
import io.github.searchndstroy.listeners.RegenSwordListener0;
import io.github.searchndstroy.listeners.RegenSwordListener1;
import io.github.searchndstroy.listeners.RegenSwordListener2;
import io.github.searchndstroy.listeners.RegenSwordListener3;
import io.github.searchndstroy.listeners.RegenSwordListener4;
import io.github.searchndstroy.listeners.ResistanceswordListener0;
import io.github.searchndstroy.listeners.ResistanceswordListener1;
import io.github.searchndstroy.listeners.ResistanceswordListener2;
import io.github.searchndstroy.listeners.ResistanceswordListener3;
import io.github.searchndstroy.listeners.ResistanceswordListener4;
import io.github.searchndstroy.listeners.SlowswordListener0;
import io.github.searchndstroy.listeners.SlowswordListener1;
import io.github.searchndstroy.listeners.SlowswordListener2;
import io.github.searchndstroy.listeners.SlowswordListener3;
import io.github.searchndstroy.listeners.SlowswordListener4;
import io.github.searchndstroy.listeners.SpeedbootsListener0;
import io.github.searchndstroy.listeners.SpeedbootsListener1;
import io.github.searchndstroy.listeners.SpeedbootsListener2;
import io.github.searchndstroy.listeners.SpeedbootsListener3;
import io.github.searchndstroy.listeners.SpeedbootsListener4;
import io.github.searchndstroy.listeners.StrengthhelmetListener0;
import io.github.searchndstroy.listeners.StrengthhelmetListener1;
import io.github.searchndstroy.listeners.StrengthhelmetListener2;
import io.github.searchndstroy.listeners.StrengthhelmetListener3;
import io.github.searchndstroy.listeners.StrengthhelmetListener4;
import io.github.searchndstroy.listeners.WitherSWordListener4;
import io.github.searchndstroy.listeners.WitherSwordListener0;
import io.github.searchndstroy.listeners.WitherSwordListener1;
import io.github.searchndstroy.listeners.WitherSwordListener2;
import io.github.searchndstroy.listeners.WitherSwordListener3;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static FileConfiguration config;
	private FileConfiguration EnchantConfig;
	private File EnchantConfigFile;

	private File DataFolder = getDataFolder();

	public void reloadCustomConfig() {
		if (EnchantConfig == null) {
			EnchantConfigFile = new File(DataFolder, "EnchantConfig.yml");
		}

		EnchantConfig = YamlConfiguration.loadConfiguration(EnchantConfigFile);

		InputStream defConfigStream = this.getResource("EnchantConfig.yml");
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration
					.loadConfiguration(defConfigStream);
			EnchantConfig.setDefaults(defConfig);
		}
	}

	public FileConfiguration getCustomConfig() {
		if (EnchantConfig == null) {
			reloadCustomConfig();
		}
		return EnchantConfig;
	}

	public void saveCustomConfig() {
		if (EnchantConfig == null || EnchantConfigFile == null) {
			return;
		}
		try {
			getCustomConfig().save(EnchantConfigFile);
		} catch (IOException IOEx) {
			getLogger().log(Level.SEVERE,
					"Could not save config file to " + EnchantConfigFile, IOEx);
		}
	}

	public void saveDefaultConfig() {

		if (EnchantConfigFile == null) {
			EnchantConfigFile = new File(DataFolder, "EnchantConfig");
		}
		if (!EnchantConfigFile.exists()) {

			saveResource("EnchantConfig.yml", false);
		}
	}

	public void onEnable() {
		
		config = getCustomConfig();

		getCommand("customenchants").setExecutor(new CustomEnchants());
		getCommand("reloadcustomenchants").setExecutor(new ReloadCustomEnchants(this));
		getCommand("enchantinformation").setExecutor(new EnchantInformation(this));

		PluginManager Regensword0 = this.getServer().getPluginManager();
		Regensword0.registerEvents(new RegenSwordListener0(this), this);

		PluginManager Regensword1 = this.getServer().getPluginManager();
		Regensword1.registerEvents(new RegenSwordListener1(this), this);

		PluginManager Regensword2 = this.getServer().getPluginManager();
		Regensword2.registerEvents(new RegenSwordListener2(this), this);

		PluginManager Regensword3 = this.getServer().getPluginManager();
		Regensword3.registerEvents(new RegenSwordListener3(this), this);

		PluginManager Regensword4 = this.getServer().getPluginManager();
		Regensword4.registerEvents(new RegenSwordListener4(this), this);

		PluginManager Poisonsword0 = this.getServer().getPluginManager();
		Poisonsword0.registerEvents(new PoisonSwordListener0(this), this);

		PluginManager Poisonsword1 = this.getServer().getPluginManager();
		Poisonsword1.registerEvents(new PoisonSwordListener1(this), this);

		PluginManager Poisonsword2 = this.getServer().getPluginManager();
		Poisonsword2.registerEvents(new PoisonSwordListener2(this), this);

		PluginManager Poisonsword3 = this.getServer().getPluginManager();
		Poisonsword3.registerEvents(new PoisonSwordListener3(this), this);

		PluginManager Poisonsword4 = this.getServer().getPluginManager();
		Poisonsword4.registerEvents(new PoisonSwordListener4(this), this);

		PluginManager Withersword0 = this.getServer().getPluginManager();
		Withersword0.registerEvents(new WitherSwordListener0(this), this);

		PluginManager Withersword1 = this.getServer().getPluginManager();
		Withersword1.registerEvents(new WitherSwordListener1(this), this);

		PluginManager Withersword2 = this.getServer().getPluginManager();
		Withersword2.registerEvents(new WitherSwordListener2(this), this);

		PluginManager Withersword3 = this.getServer().getPluginManager();
		Withersword3.registerEvents(new WitherSwordListener3(this), this);

		PluginManager Withersword4 = this.getServer().getPluginManager();
		Withersword4.registerEvents(new WitherSWordListener4(this), this);

		PluginManager Slowsword0 = this.getServer().getPluginManager();
		Slowsword0.registerEvents(new SlowswordListener0(this), this);

		PluginManager Slowsword1 = this.getServer().getPluginManager();
		Slowsword1.registerEvents(new SlowswordListener1(this), this);

		PluginManager Slowsword2 = this.getServer().getPluginManager();
		Slowsword2.registerEvents(new SlowswordListener2(this), this);

		PluginManager Slowsword3 = this.getServer().getPluginManager();
		Slowsword3.registerEvents(new SlowswordListener3(this), this);

		PluginManager Slowsword4 = this.getServer().getPluginManager();
		Slowsword4.registerEvents(new SlowswordListener4(this), this);

		PluginManager Blindsword0 = this.getServer().getPluginManager();
		Blindsword0.registerEvents(new BlindswordListener0(this), this);

		PluginManager Blindsword1 = this.getServer().getPluginManager();
		Blindsword1.registerEvents(new BlindswordListener1(this), this);

		PluginManager Blindsword2 = this.getServer().getPluginManager();
		Blindsword2.registerEvents(new BlindswordListener2(this), this);

		PluginManager Blindsword3 = this.getServer().getPluginManager();
		Blindsword3.registerEvents(new BlindswordListener3(this), this);

		PluginManager Blindsword4 = this.getServer().getPluginManager();
		Blindsword4.registerEvents(new BlindswordListener4(this), this);

		PluginManager Nauseasword0 = this.getServer().getPluginManager();
		Nauseasword0.registerEvents(new NauseaswordListener0(this), this);

		PluginManager Nauseasword1 = this.getServer().getPluginManager();
		Nauseasword1.registerEvents(new NauseaswordListener1(this), this);

		PluginManager Nauseasword2 = this.getServer().getPluginManager();
		Nauseasword2.registerEvents(new NauseaswordListener2(this), this);

		PluginManager Nauseasword3 = this.getServer().getPluginManager();
		Nauseasword3.registerEvents(new NauseaswordListener3(this), this);

		PluginManager Nauseasword4 = this.getServer().getPluginManager();
		Nauseasword4.registerEvents(new NauseaswordListener4(this), this);

		PluginManager Resistancesword0 = this.getServer().getPluginManager();
		Resistancesword0.registerEvents(new ResistanceswordListener0(this),
				this);

		PluginManager Resistancesword1 = this.getServer().getPluginManager();
		Resistancesword1.registerEvents(new ResistanceswordListener1(this),
				this);

		PluginManager Resistancesword2 = this.getServer().getPluginManager();
		Resistancesword2.registerEvents(new ResistanceswordListener2(this),
				this);

		PluginManager Resistancesword3 = this.getServer().getPluginManager();
		Resistancesword3.registerEvents(new ResistanceswordListener3(this),
				this);

		PluginManager Resistancesword4 = this.getServer().getPluginManager();
		Resistancesword4.registerEvents(new ResistanceswordListener4(this),
				this);

		PluginManager LeechHungersword0 = this.getServer().getPluginManager();
		LeechHungersword0.registerEvents(new LeechHungerswordListener0(this),
				this);

		PluginManager LeechHungersword1 = this.getServer().getPluginManager();
		LeechHungersword1.registerEvents(new LeechHungerswordListener1(this),
				this);

		PluginManager LeechHungersword2 = this.getServer().getPluginManager();
		LeechHungersword2.registerEvents(new LeechHungerswordListener2(this),
				this);

		PluginManager LeechHungersword3 = this.getServer().getPluginManager();
		LeechHungersword3.registerEvents(new LeechHungerswordListener3(this),
				this);

		PluginManager LeechHungersword4 = this.getServer().getPluginManager();
		LeechHungersword4.registerEvents(new LeechHungerswordListener4(this),
				this);

		PluginManager SpeedbootsListener0 = this.getServer().getPluginManager();
		SpeedbootsListener0.registerEvents(new SpeedbootsListener0(this), this);

		PluginManager SpeedbootsListener1 = this.getServer().getPluginManager();
		SpeedbootsListener1.registerEvents(new SpeedbootsListener1(this), this);

		PluginManager SpeedbootsListener2 = this.getServer().getPluginManager();
		SpeedbootsListener2.registerEvents(new SpeedbootsListener2(this), this);

		PluginManager SpeedbootsListener3 = this.getServer().getPluginManager();
		SpeedbootsListener3.registerEvents(new SpeedbootsListener3(this), this);

		PluginManager SpeedbootsListener4 = this.getServer().getPluginManager();
		SpeedbootsListener4.registerEvents(new SpeedbootsListener4(this), this);

		PluginManager InvisibilityswordListener0 = this.getServer()
				.getPluginManager();
		InvisibilityswordListener0.registerEvents(
				new InvisibilityswordListener0(this), this);

		PluginManager InvisibilityswordListener1 = this.getServer()
				.getPluginManager();
		InvisibilityswordListener1.registerEvents(
				new InvisibilityswordListener1(this), this);

		PluginManager InvisibilityswordListener2 = this.getServer()
				.getPluginManager();
		InvisibilityswordListener2.registerEvents(
				new InvisibilityswordListener2(this), this);

		PluginManager InvisibilityswordListener3 = this.getServer()
				.getPluginManager();
		InvisibilityswordListener3.registerEvents(
				new InvisibilityswordListener3(this), this);

		PluginManager InvisibilityswordListener4 = this.getServer()
				.getPluginManager();
		InvisibilityswordListener4.registerEvents(
				new InvisibilityswordListener4(this), this);

		PluginManager StrengthhelmetListener0 = this.getServer()
				.getPluginManager();
		StrengthhelmetListener0.registerEvents(
				new StrengthhelmetListener0(this), this);

		PluginManager StrengthhelmetListener1 = this.getServer()
				.getPluginManager();
		StrengthhelmetListener1.registerEvents(
				new StrengthhelmetListener1(this), this);

		PluginManager StrengthhelmetListener2 = this.getServer()
				.getPluginManager();
		StrengthhelmetListener2.registerEvents(
				new StrengthhelmetListener2(this), this);

		PluginManager StrengthhelmetListener3 = this.getServer()
				.getPluginManager();
		StrengthhelmetListener3.registerEvents(
				new StrengthhelmetListener3(this), this);

		PluginManager StrengthhelmetListener4 = this.getServer()
				.getPluginManager();
		StrengthhelmetListener4.registerEvents(
				new StrengthhelmetListener4(this), this);

		saveDefaultConfig();
		
		saveConfig();
		getLogger().info("Plugin enabled. Have fun :D");

	}

	public void onDisable() {

		getLogger().info("Plugin disabled");

	}
}
