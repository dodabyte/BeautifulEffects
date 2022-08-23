package ru.dodabyte.beautifuleffects.menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import ru.dodabyte.beautifuleffects.effects.Effects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EffectsMenu {
    private final List<MenuSlot> menu;
    private final Inventory inventory;

    public EffectsMenu() {
        List<EffectsItemSlot> effectsList = new ArrayList<>();
        for (Effects effect : Effects.values()) {
            effectsList.add(new EffectsItemSlot(
                    new ItemStack(effect.getIcon()),
                    effect.getName(),
                    effect.getDescription()));
        }

        menu = Arrays.asList(
                new MenuSlot(new ItemStack(Material.NETHERITE_SWORD), "Melee effects",
                        "Effects that will appear when fighting mobs or players.", effectsList),
                new MenuSlot(new ItemStack(Material.BOW), "Bow effects",
                        "Effects that display the trace of an arrow when fired from a bow.", effectsList)
        );

        inventory = Bukkit.createInventory(null, 54, "Choose a category");

        addGlassPaneFrame();

        inventory.setItem(20, menu.get(0).getCategorySelection());
        inventory.setItem(24, menu.get(1).getCategorySelection());
    }

    public void addGlassPaneFrame() {
        for (int slot = 0, row = 0, columns = 0; slot < inventory.getSize();  slot++, columns++) {
            if (row == 0 || row == (inventory.getSize() / 9) - 1) {
                inventory.setItem(slot, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
            }
            if (slot % 9 == 8 || slot % 9 == 0) {
                inventory.setItem(slot, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
            }
            if (columns >= 9) {
                columns = 0;
                row++;
            }
        }
    }

    public List<MenuSlot> getMenu() {
        return menu;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
