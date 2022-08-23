package ru.dodabyte.beautifuleffects.effects;

import org.bukkit.Particle;
import org.bukkit.entity.Entity;

import java.util.Objects;

public class ParticleArrow {
    private final Entity arrow;
    private final Particle particle;

    public ParticleArrow(Entity arrow, Particle particle) {
        this.arrow = arrow;
        this.particle = particle;
    }

    public void spawnParticle() {
        if (arrow != null)
            arrow.getWorld().spawnParticle(particle, arrow.getLocation(), 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticleArrow that = (ParticleArrow) o;
        return Objects.equals(arrow.getUniqueId(), that.arrow.getUniqueId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrow.getUniqueId());
    }

}
