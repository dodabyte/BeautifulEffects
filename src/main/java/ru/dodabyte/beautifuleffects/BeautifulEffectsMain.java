package ru.dodabyte.beautifuleffects;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.dodabyte.beautifuleffects.commands.GeneralCommands;
import ru.dodabyte.beautifuleffects.effects.EffectsSelection;
import ru.dodabyte.beautifuleffects.effects.event.CreateEffectsBow;
import ru.dodabyte.beautifuleffects.effects.event.CreateEffectsMelee;
import ru.dodabyte.beautifuleffects.items.MenuItem;
import ru.dodabyte.beautifuleffects.menu.EffectsMenu;
import ru.dodabyte.beautifuleffects.menu.event.DragMenuItem;
import ru.dodabyte.beautifuleffects.menu.event.OpenMenu;

public final class BeautifulEffectsMain extends JavaPlugin {

    private static EffectsMenu effectsMenu;
    private static MenuItem menuItem;

    public BeautifulEffectsMain() {
        effectsMenu = new EffectsMenu();
        menuItem = new MenuItem();
    }

    @Override
    public void onEnable() {
        registerCommands();
        registerEvents();
        EffectsSelection.schedulerParticleArrow();
    }

    @Override
    public void onDisable() {

    }

    public void registerCommands() {
        new GeneralCommands(this);
    }

    public void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new OpenMenu(), this);
        Bukkit.getPluginManager().registerEvents(new DragMenuItem(), this);
        Bukkit.getPluginManager().registerEvents(new CreateEffectsMelee(), this);
        Bukkit.getPluginManager().registerEvents(new CreateEffectsBow(), this);
    }

    public static EffectsMenu getEffectsMenu() { return effectsMenu; }
}
