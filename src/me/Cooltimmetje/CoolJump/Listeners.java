package me.Cooltimmetje.CoolJump;

import com.darkblade12.particleeffect.ParticleEffect;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

/**
 * This class has been created on 19-5-2015 at 19:14 by cooltimmetje.
 */
public class Listeners implements Listener {

    public static double upwardForce;
    public static double forwardForce;

    @EventHandler
    public static void onFly(PlayerToggleFlightEvent event){
        Player p = event.getPlayer();
        if(p.getGameMode() != GameMode.CREATIVE && event.isFlying()) {
            event.setCancelled(true);

            Vector jump = p.getLocation().getDirection().multiply(0.4).setY(1.1);
            p.setVelocity(p.getVelocity().add(jump));
            p.setAllowFlight(false);
            p.setFallDistance(1);
            p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 100, 1);
            ParticleEffect.CLOUD.display(1,1,1,1,20,p.getLocation(), 20);

        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void dmg(final EntityDamageEvent event) {
        Entity e = event.getEntity();
        if(e instanceof Player) {
            if(event.getCause() == EntityDamageEvent.DamageCause.FALL){
                Player p = (Player) e;
                if(p.hasPermission("cooljump.jump")){
                    event.setCancelled(true);
                    p.setAllowFlight(true);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.getPlayer().setAllowFlight(event.getPlayer().hasPermission("cooljump.jump"));
    }

}
