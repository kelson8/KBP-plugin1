package me.Kelson.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.Kelson.Main;

public class KMotdCommand implements CommandExecutor, Listener
{
	Main plugin;
	
	public KMotdCommand(Main passedPlugin){
		this.plugin = passedPlugin;
	}

        @EventHandler
        public void onPlayerJoin(PlayerJoinEvent event) {
                Player player = event.getPlayer();
                player.sendMessage(plugin.getConfig().getString("motd"));
        }
       
        public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        	      //This part is the console version of the kmotd command
        	      if(!(sender instanceof Player)){
        	    	if (cmd.getName().equalsIgnoreCase("kmotd")) {
                        //plugin.getConfig().replaceAll("&y", ChatColor.YELLOW);
                            sender.sendMessage("MOTD: " + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("motd"))
                            		.replace("*new_line*", "\n")
                            		.replace("%s", "Console")
                            	    .replace("%w", "")
                            	    .replace("player", ""));
                            return true;
        	    	}
        	      }
        		Player player = (Player) sender;
        		
        		//This part is the player version of the kmotd command
        		if(sender instanceof Player){
                if (cmd.getName().equalsIgnoreCase("kmotd")) {
                        sender.sendMessage("MOTD: " + ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("motd"))
                        		.replace("%s", player.getName())
                        		.replace("%w", player.getWorld().getName())
                        		.replace("*new_line*", "\n"));
                        return true;
                  }
        		}
				return false;
				
        }

}