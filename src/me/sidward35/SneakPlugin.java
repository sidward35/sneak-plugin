package me.sidward35;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SneakPlugin extends JavaPlugin{
	@Override
	public void onEnable(){
		getLogger().info("SneakPlugin enabled.");
	}
	
	@Override
	public void onDisable(){}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[]args){
		if(cmd.getName().equalsIgnoreCase("sneak") && sender instanceof Player){
			Player player = (Player)sender;
			if(!player.isSneaking()){
				float speed = player.getWalkSpeed();
				player.setSneaking(true);
				player.setWalkSpeed(speed);
				player.sendMessage("Sneak enabled with regular walking speed.");
			}
			else{
				player.setSneaking(false);
				player.sendMessage("Sneak with regular walking speed disabled.");
			}
			return true;
		}
		return false;
	}
}
