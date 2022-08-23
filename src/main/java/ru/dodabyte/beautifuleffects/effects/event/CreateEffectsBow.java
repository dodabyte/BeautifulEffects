package ru.dodabyte.beautifuleffects.effects.event;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import ru.dodabyte.beautifuleffects.effects.EffectsSelection;
import ru.dodabyte.beautifuleffects.effects.ParticleArrow;

public class CreateEffectsBow implements Listener {

    @EventHandler
    public void onBowShoot(EntityShootBowEvent event) {
        if (event.getEntity() instanceof Player) {
            try {
                EffectsSelection.getArrowMap().put(event.getProjectile().getUniqueId(),
                        new ParticleArrow(event.getProjectile(),
                                EffectsSelection.getSelectedEffectBow(event.getEntity().getUniqueId()).getParticle()));
            }
            catch (NullPointerException e) {}
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Arrow) {
            EffectsSelection.getArrowMap().remove(event.getEntity().getUniqueId());
        }
    }
}
