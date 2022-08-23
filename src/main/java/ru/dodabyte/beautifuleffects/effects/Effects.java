package ru.dodabyte.beautifuleffects.effects;

import org.bukkit.Material;
import org.bukkit.Particle;

public enum Effects {
    BACK(Material.RED_STAINED_GLASS_PANE, "<--",
            "Go back to the previous page...", null),
    NONE(Material.BARRIER, "None",
            "The purest person is the one without effects.", null),
    FIRE(Material.BLAZE_POWDER, "Fire",
            "Turns on the fire effect, as if you are a hot boy.", Particle.LAVA),
    SNOW(Material.SNOWBALL, "Snow",
            "Break someone else's heart with your cold heart.", Particle.SNOWBALL),
    EVAPORATION(Material.DEAD_BRAIN_CORAL, "Evaporation",
            "The particles of the body gradually evaporate.", Particle.CLOUD),
    AXII(Material.WHEAT_SEEDS, "Axii",
            "Perhaps this way you will stupefy the enemy's mind.", Particle.COMPOSTER),
    YRDEN(Material.PURPLE_DYE, "Yrden",
            "Powerful creature attraction magic.", Particle.DRAGON_BREATH);

    private final Material icon;
    private final String name;
    private final String description;
    private final Particle particle;

    Effects(Material icon, String name, String description, Particle particle) {
        this.icon = icon;
        this.name = name;
        this.description = description;
        this.particle = particle;
    }

    public Material getIcon() { return icon; }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public Particle getParticle() { return particle; }

    public static Effects getEffectsFromIcon(Material icon) {
        for (Effects effect : Effects.values()) {
            if (effect.getIcon().equals(icon)) {
                return effect;
            }
        }
        return null;
    }
}
