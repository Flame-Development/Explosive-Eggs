package ir.flamedevelopment;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Egg;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ExplosiveEggs extends JavaPlugin implements Listener {

    public static boolean Listening;
    private static int Radius;

    @Override
    public void onEnable() {
        long start = System.currentTimeMillis();

        getServer().getPluginManager().registerEvents(this, this);
        Objects.requireNonNull(getCommand("start")).setExecutor(new StartCommand());
        saveDefaultConfig();
        Listening = false;
        Radius = getConfig().getInt("ExplosionRadius");

        long stop = System.currentTimeMillis();
        long time = stop - start;
        getLogger().info("Took " + time + "MS To Enable.");
    }
    @EventHandler
    public void OnProjectileHit (ProjectileHitEvent event) {
        if (Listening && event.getEntity() instanceof Egg) {
            Egg Projectile = (Egg) event.getEntity();
            Location Loc = Projectile.getLocation();
            // Explosion Delay
            Bukkit.getScheduler().runTaskLater(this, () -> Objects.requireNonNull(Loc.getWorld()).createExplosion(Loc, Radius), 1);

        }
    }
}
