package io.github.searchndstroy.customenchants.listeners;

import io.github.searchndstroy.customenchants.common.CustomEnchants;

import java.util.logging.Level;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class FishingTestListener implements Listener {
	
	private String objectToString(Object arg) {
		
		String string = arg + "";
		
		return string;
	}
	
	private int randompercent = 0;
	private int randompercentgenerator = 0;
	private String message = "";
	private String currencysymbol = "";
	private String logmessage = "";
	private String currencysymbolpos = "";
	
	@EventHandler(ignoreCancelled = true)
	public void onPlayerFish(PlayerFishEvent e) {
		
		Entity caught = e.getCaught();
		Player player = e.getPlayer();
		
		if (caught == null || !caught.isValid())
			return;
		
		int random = (int) Math.random() * randompercentgenerator;
		
		if (random < randompercent) {
			
			if (currencysymbolpos.equalsIgnoreCase("left")) {
				
				message.replace(":MONEY", currencysymbol + objectToString(random));
				logmessage.replace(":MONEY", currencysymbol + objectToString(random));
				
			} else if (currencysymbolpos.equalsIgnoreCase("right")) {
				
				message.replace(":MONEY", objectToString(random) + currencysymbol);
				logmessage.replace(":MONEY", objectToString(random) + currencysymbol);
				
			}
			logmessage.replace(":PLAYER", player.getName());
			
			CustomEnchants.economy.depositPlayer(player.getName(), random);
			player.sendMessage(message);
			CustomEnchants plugin = new CustomEnchants();
			plugin.logger.log(Level.INFO, logmessage);
		}
		
	}

}
