package ru.dodabyte.beautifuleffects.effects.event;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import ru.dodabyte.beautifuleffects.effects.EffectsSelection;

public class CreateEffectsMelee implements Listener {

    @EventHandler
    public void onPvpDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Location locationEntity = event.getEntity().getLocation();
            locationEntity.setY(locationEntity.getY() + 1);
            try {
                locationEntity.getWorld().spawnParticle(
                        EffectsSelection.getSelectedEffectMelee(event.getDamager().getUniqueId()).getParticle(),
                        locationEntity, 10);
            }
            catch (NullPointerException e) {}
        }
    }
}
