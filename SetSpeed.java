package me.IronCrystal.SetSpeed;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SetSpeed extends JavaPlugin
{
public final Logger logger = Logger.getLogger("Minecraft");
public static SetSpeed plugin;
public final SpeedListener PlayerListener = new SpeedListener(this);

int speedFly = 1;
double speedWater = 1D;
int speedLand = 1;


public void onDisable()
{
PluginDescriptionFile pdfFile = getDescription();
this.logger.info(String.valueOf(pdfFile.getName()) + " is now disabled!");
}


public void onEnable()
{
PluginDescriptionFile pdfFile = getDescription();
this.logger.info(String.valueOf(pdfFile.getName()) + " version " + pdfFile.getVersion() + " has been enabled.");
PluginManager pm = getServer().getPluginManager();
pm.registerEvents(this.PlayerListener, this);
}

public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
{
Player player = (Player)sender;

if ((sender instanceof Player))
{
if (cmd.getName().equalsIgnoreCase("sp"))
{
if (player.hasPermission("sp.all"))
{
if (args.length == 1)
{
int sp = Integer.parseInt(args[0]);
if (sp > 10)
{
player.sendMessage(ChatColor.RED + "Too fast!");
player.sendMessage(ChatColor.RED + "10 is the max");
return true;
}
player.sendMessage(ChatColor.GREEN + "All speeds will be multiplied by " + sp);
this.speedLand = sp;
this.speedWater = sp;
this.speedFly = sp;
}
else
{
player.sendMessage(ChatColor.GREEN + "/sp <multiplier> - multiplies all speeds");
player.sendMessage(ChatColor.GREEN + "/spa <multiplier> - multiplies air speeds");
player.sendMessage(ChatColor.GREEN + "/spl <multiplier> - multiplies sprint speeds");
player.sendMessage(ChatColor.GREEN + "/spw <multiplier> - multiplies swim speeds");
}

}
else {
player.sendMessage(ChatColor.RED + "You do not have the proper permissions to perform that command");
}
}
else if (cmd.getName().equalsIgnoreCase("spa"))
{
if (player.hasPermission("sp.air"))
{
if (args.length == 1)
{
int sp = Integer.parseInt(args[0]);
if (sp > 10)
{
player.sendMessage(ChatColor.RED + "Too fast!");
player.sendMessage(ChatColor.RED + "10 is the max");
return true;
}
player.sendMessage(ChatColor.GREEN + "All air speeds will be multiplied by " + sp);
this.speedFly = sp;
}

}
else {
player.sendMessage(ChatColor.RED + "You do not have the proper permissions to perform that command");
}
}
else if (cmd.getName().equalsIgnoreCase("spl"))
{
if (player.hasPermission("sp.land"))
{
if (args.length == 1)
{
int sp = Integer.parseInt(args[0]);
if (sp > 10)
{
player.sendMessage(ChatColor.RED + "Too fast!");
player.sendMessage(ChatColor.RED + "10 is the max");
return true;
}
player.sendMessage(ChatColor.GREEN + "All land speeds will be multiplied by " + sp);
this.speedLand = sp;
}

}
else {
player.sendMessage(ChatColor.RED + "You do not have the proper permissions to perform that command");
}
}
else if (cmd.getName().equalsIgnoreCase("spw"))
{
if (player.hasPermission("sp.water"))
{
if (args.length == 1)
{
int sp = Integer.parseInt(args[0]);
if (sp > 10)
{
player.sendMessage(ChatColor.RED + "Too fast!");
player.sendMessage(ChatColor.RED + "10 is the max");
return true;
}
player.sendMessage(ChatColor.GREEN + "All water speeds will be multiplied by " + sp);
this.speedWater = sp;
}

}
else {
player.sendMessage(ChatColor.RED + "You do not have the proper permissions to perform that command");
}
}
}
return false;
}
} 
