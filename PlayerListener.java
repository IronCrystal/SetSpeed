package me.IronCrystal.SetSpeed;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class SpeedListener implements org.bukkit.event.Listener
{
public static SetSpeed plugin;

public SpeedListener(SetSpeed instance)
{
plugin = instance;
}

@org.bukkit.event.EventHandler
public void onPlayerMoveEvent(PlayerMoveEvent event)
{
Player player = event.getPlayer();

Location playerLocation = event.getPlayer().getLocation();
double y = playerLocation.getBlockY();
double x = playerLocation.getBlockX();
double z = playerLocation.getBlockZ();

World currentWorld = event.getPlayer().getWorld();

Location blockBelow = new Location(currentWorld, x, y - 2.0D, z);

if (player.isSprinting())
{
if (plugin.speedLand > 1)
{
player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, plugin.speedLand - 2));
}
}
else if ((player.getAllowFlight()) && (blockBelow.getBlock().getType().equals(Material.AIR)))
{
if (plugin.speedFly > 1)
{
player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, plugin.speedFly - 2));
}
}
else if (playerLocation.getBlock().getType().equals(Material.STATIONARY_WATER))
{
if (plugin.speedWater > 1D)
{
Vector dir = player.getLocation().getDirection().normalize().multiply(plugin.speedWater - 1.6D);
Vector vec = new Vector(dir.getX(), dir.getY(), dir.getZ());
player.setVelocity(vec);
}

}
else {
player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 0, 0), true);
}
}
} 
