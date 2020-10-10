package me.Kelson;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DisablewhitelistCommand implements CommandExecutor 
{
		Main plugin;
		
		public DisablewhitelistCommand(Main passedPlugin)
		{
			this.plugin = passedPlugin;
		}
        
		public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
			
		        if(cmd.getName().equalsIgnoreCase("disablewhitelist") && sender.hasPermission("kelson.disablewhitelist")) {
        	    plugin.getServer().setWhitelist(false);
                Bukkit.broadcastMessage(Main.main + sender.getName() + " Has disabled the whitelist!");
		        }
			
			return false;
		}
}
