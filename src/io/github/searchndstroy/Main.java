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

import io.github.searchndstroy.listeners.*;
import io.github.searchndstroy.commands.*;
import io.github.searchndstroy.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


@SuppressWarnings("unused")
public class Main extends JavaPlugin {
	
	private static Main instance;
	
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
	        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
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
	        getLogger().log(Level.SEVERE, "Could not save config file to " + EnchantConfigFile, IOEx);
	    }
	}
	
	public void saveDefaultConfig() {
		
	    if (EnchantConfigFile == null) {
	        EnchantConfigFile = new File(getDataFolder(), "EnchantConfig");
	    }
	    if (!EnchantConfigFile.exists()) {       
	    	
	         saveResource("EnchantConfig.yml", false);
	     }
	}

	public void onEnable() {
		
		this.reloadCustomConfig();
		this.getCustomConfig();
		
		getCommand("customenchants").setExecutor(new CustomEnchants());

		PluginManager Regensword0 = this.getServer().getPluginManager();
		Regensword0.registerEvents(new RegenSwordListener0(), this);
		
		PluginManager Regensword1 = this.getServer().getPluginManager();
		Regensword1.registerEvents(new RegenSwordListener1(), this);
		
		PluginManager Regensword2 = this.getServer().getPluginManager();
		Regensword2.registerEvents(new RegenSwordListener2(),this);
		
		PluginManager Regensword3 = this.getServer().getPluginManager();
		Regensword3.registerEvents(new RegenSwordListener3(), this);
		
		PluginManager Regensword4 = this.getServer().getPluginManager();
		Regensword4.registerEvents(new RegenSwordListener4(), this);
		
		PluginManager Poisonsword0 = this.getServer().getPluginManager();
		Poisonsword0.registerEvents(new PoisonSwordListener0(), this);
		
		PluginManager Poisonsword1 = this.getServer().getPluginManager();
		Poisonsword1.registerEvents(new PoisonSwordListener1(), this);
		
		PluginManager Poisonsword2 = this.getServer().getPluginManager();
		Poisonsword2.registerEvents(new PoisonSwordListener2(), this);
		
		PluginManager Poisonsword3 = this.getServer().getPluginManager();
		Poisonsword3.registerEvents(new PoisonSwordListener3(), this);
		
		PluginManager Poisonsword4 = this.getServer().getPluginManager();
		Poisonsword4.registerEvents(new PoisonSwordListener4(), this);
		
		PluginManager Withersword0 = this.getServer().getPluginManager();
		Withersword0.registerEvents(new WitherSwordListener0(), this);
		
		PluginManager Withersword1 = this.getServer().getPluginManager();
		Withersword1.registerEvents(new WitherSwordListener1(), this);
		
		PluginManager Withersword2 = this.getServer().getPluginManager();
		Withersword2.registerEvents(new WitherSwordListener2(), this);
		
		PluginManager Withersword3 = this.getServer().getPluginManager();
		Withersword3.registerEvents(new WitherSwordListener3(), this);
		
		PluginManager Withersword4 = this.getServer().getPluginManager();
		Withersword4.registerEvents(new WitherSWordListener4(), this);
		
		PluginManager Slowsword0 = this.getServer().getPluginManager();
		Slowsword0.registerEvents(new SlowswordListener0(), this);

		PluginManager Slowsword1 = this.getServer().getPluginManager();
		Slowsword1.registerEvents(new SlowswordListener1(), this);
		
		PluginManager Slowsword2 = this.getServer().getPluginManager();
		Slowsword2.registerEvents(new SlowswordListener2(), this);
		
		PluginManager Slowsword3 = this.getServer().getPluginManager();
		Slowsword3.registerEvents(new SlowswordListener3(), this);
		
		PluginManager Slowsword4 = this.getServer().getPluginManager();
		Slowsword4.registerEvents(new SlowswordListener4(), this);
		
		PluginManager Blindsword0 = this.getServer().getPluginManager();
		Blindsword0.registerEvents(new BlindswordListener0(), this);
		
		PluginManager Blindsword1 = this.getServer().getPluginManager();
		Blindsword1.registerEvents(new BlindswordListener1(), this);
		
		PluginManager Blindsword2 = this.getServer().getPluginManager();
		Blindsword2.registerEvents(new BlindswordListener2(), this);
		
		PluginManager Blindsword3 = this.getServer().getPluginManager();
		Blindsword3.registerEvents(new BlindswordListener3(), this);
		
		PluginManager Blindsword4 = this.getServer().getPluginManager();
		Blindsword4.registerEvents(new BlindswordListener4(), this);
		
		PluginManager Nauseasword0 = this.getServer().getPluginManager();
		Nauseasword0.registerEvents(new NauseaswordListener0(), this);
		
		PluginManager Nauseasword1 = this.getServer().getPluginManager();
		Nauseasword1.registerEvents(new NauseaswordListener1(), this);
		
		PluginManager Nauseasword2 = this.getServer().getPluginManager();
		Nauseasword2.registerEvents(new NauseaswordListener2(), this);
		
		PluginManager Nauseasword3 = this.getServer().getPluginManager();
		Nauseasword3.registerEvents(new NauseaswordListener3(), this);
		
		PluginManager Nauseasword4 = this.getServer().getPluginManager();
		Nauseasword4.registerEvents(new NauseaswordListener4(), this);
		
		PluginManager Resistancesword0 = this.getServer().getPluginManager();
		Resistancesword0.registerEvents(new ResistanceswordListener0(), this);
		
		PluginManager Resistancesword1 = this.getServer().getPluginManager();
		Resistancesword1.registerEvents(new ResistanceswordListener1(), this);
		
		PluginManager Resistancesword2 = this.getServer().getPluginManager();
	    Resistancesword2.registerEvents(new ResistanceswordListener2(), this);
		
		PluginManager Resistancesword3 = this.getServer().getPluginManager();
		Resistancesword3.registerEvents(new ResistanceswordListener3(), this);
		
	    PluginManager Resistancesword4 = this.getServer().getPluginManager();
		Resistancesword4.registerEvents(new ResistanceswordListener4(), this);
		
		PluginManager LeechHungersword0 = this.getServer().getPluginManager();
		LeechHungersword0.registerEvents(new LeechHungerswordListener0(), this);
		
		PluginManager LeechHungersword1 = this.getServer().getPluginManager();
		LeechHungersword1.registerEvents(new LeechHungerswordListener1(), this);
		
		PluginManager LeechHungersword2 = this.getServer().getPluginManager();
		LeechHungersword2.registerEvents(new LeechHungerswordListener2(), this);
		
		PluginManager LeechHungersword3 = this.getServer().getPluginManager();
		LeechHungersword3.registerEvents(new LeechHungerswordListener3(), this);
        
		PluginManager LeechHungersword4 = this.getServer().getPluginManager();
	    LeechHungersword4.registerEvents(new LeechHungerswordListener4(), this);
	    
	    PluginManager SpeedbootsListener0 = this.getServer().getPluginManager();
	    SpeedbootsListener0.registerEvents(new SpeedbootsListener0(), this);
	    
	    PluginManager SpeedbootsListener1 = this.getServer().getPluginManager();
	    SpeedbootsListener1.registerEvents(new SpeedbootsListener1(), this);
	    
	    PluginManager SpeedbootsListener2 = this.getServer().getPluginManager();
	    SpeedbootsListener2.registerEvents(new SpeedbootsListener2(), this);
	    
	    PluginManager SpeedbootsListener3 = this.getServer().getPluginManager();
	    SpeedbootsListener3.registerEvents(new SpeedbootsListener3(), this);
	    
	    PluginManager SpeedbootsListener4 = this.getServer().getPluginManager();
	    SpeedbootsListener4.registerEvents(new SpeedbootsListener4(), this);
	    
	    PluginManager InvisibilityswordListener0 = this.getServer().getPluginManager();
	    InvisibilityswordListener0.registerEvents(new InvisibilityswordListener0(), this);
	    
	    PluginManager InvisibilityswordListener1 = this.getServer().getPluginManager();
	    InvisibilityswordListener1.registerEvents(new InvisibilityswordListener1(), this);
	    
	    PluginManager InvisibilityswordListener2 = this.getServer().getPluginManager();
	    InvisibilityswordListener2.registerEvents(new InvisibilityswordListener2(), this);
	    
	    PluginManager InvisibilityswordListener3 = this.getServer().getPluginManager();
	    InvisibilityswordListener3.registerEvents(new InvisibilityswordListener3(), this);
	    
	    PluginManager InvisibilityswordListener4 = this.getServer().getPluginManager();
	    InvisibilityswordListener4.registerEvents(new InvisibilityswordListener4(), this);
	    
	    PluginManager StrengthhelmetListener0 = this.getServer().getPluginManager();
	    StrengthhelmetListener0.registerEvents(new StrengthhelmetListener0(), this);
	    
	    PluginManager StrengthhelmetListener1 = this.getServer().getPluginManager();
	    StrengthhelmetListener1.registerEvents(new StrengthhelmetListener1(), this);
	    
	    PluginManager StrengthhelmetListener2 = this.getServer().getPluginManager();
	    StrengthhelmetListener2.registerEvents(new StrengthhelmetListener2(), this);
	    
	    PluginManager StrengthhelmetListener3 = this.getServer().getPluginManager();
	    StrengthhelmetListener3.registerEvents(new StrengthhelmetListener3(), this);
	    
	    PluginManager StrengthhelmetListener4 = this.getServer().getPluginManager();
	    StrengthhelmetListener4.registerEvents(new StrengthhelmetListener4(), this);
	    
		getLogger().info("Plugin enabled. Have fun :D");
		
	}
	
	public void onDisable() {
		
		getLogger().info("Plugin disabled");
		
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if (commandLabel.equalsIgnoreCase("cce") || commandLabel.equalsIgnoreCase("configcustomenchants")) {
				
			if (args[0].equalsIgnoreCase("reload")) {
				this.reloadCustomConfig();
				this.getCustomConfig();
				return false;
			}
			
			return false;
		}
		return false;
		
	}
}
