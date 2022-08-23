package ru.dodabyte.beautifuleffects.effects;

import org.bukkit.Bukkit;
import ru.dodabyte.beautifuleffects.BeautifulEffectsMain;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EffectsSelection {
    private static final Map<UUID, ParticleArrow> arrowMap = new HashMap<>();
    private static final Map<UUID, Effects> uuidPlayersSelectedEffectsMelee = new HashMap<>();
    private static final Map<UUID, Effects> uuidPlayersSelectedEffectsBow = new HashMap<>();

    // TODO Сделать в дальнейшем сохранение данных об эффектах конкретных игроков в файл, вместо Map.

    public static void schedulerParticleArrow() {
        Bukkit.getScheduler().runTaskTimer(BeautifulEffectsMain.getProvidingPlugin(BeautifulEffectsMain.class), (task) -> {
            for (ParticleArrow arrow : arrowMap.values())
                arrow.spawnParticle();
        }, 0L, 1L);
    }

    public static Map<UUID, ParticleArrow> getArrowMap() { return arrowMap; }

    public static Effects getSelectedEffectMelee(UUID playerUUID) {
        return uuidPlayersSelectedEffectsMelee.get(playerUUID);
    }

    public static Effects getSelectedEffectBow(UUID playerUUID) {
        return uuidPlayersSelectedEffectsBow.get(playerUUID);
    }

    public static void setSelectedEffectMelee(UUID playerUUID, Effects effect) {
        uuidPlayersSelectedEffectsMelee.put(playerUUID, effect);
    }

    public static void setSelectedEffectBow(UUID playerUUID, Effects effect) {
        uuidPlayersSelectedEffectsBow.put(playerUUID, effect);
    }
}
