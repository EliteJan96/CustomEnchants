package io.github.searchndstroy.customenchnats.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CustomEnchantsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel,
			String[] args) {
		
		if (!(sender instanceof Player)) {
			
			sender.sendMessage("You cannot run this command as console!");
			
		} else {
			
			if (cmdlabel.equalsIgnoreCase("customenchants") || cmdlabel.equalsIgnoreCase("cmdlabel")) {
				
				
				
				return false;
			}
			
			return false;
		}
		
		return false;
	}

}
