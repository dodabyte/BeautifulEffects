package ru.dodabyte.beautifuleffects.menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuSlot {
    private final ItemStack categorySelection;
    private List<EffectsItemSlot> contents = new ArrayList<>();
    private final Inventory inventory;

    public MenuSlot(ItemStack categorySelection, String inventoryName, String description, List<EffectsItemSlot> contents) {
        this.categorySelection = categorySelection;
        this.contents = contents;
        this.inventory = Bukkit.createInventory(null, 54, inventoryName);
        List<String> lore = Arrays.asList(
                "",
                description
        );

        ItemMeta itemMeta = this.categorySelection.getItemMeta();
        itemMeta.setLore(lore);
        itemMeta.setDisplayName(inventoryName);
        this.categorySelection.setItemMeta(itemMeta);

        addGlassPaneFrame();

        addEffectsItemSlot();
    }

    public void addEffectsItemSlot() {
        int indexForEffects = 28;
        for (EffectsItemSlot effectItemSlot : contents) {
            if (effectItemSlot.getEffectSelection().getType().equals(Material.RED_STAINED_GLASS_PANE)) {
                inventory.setItem(45, effectItemSlot.getEffectSelection());
            }
            else if (effectItemSlot.getEffectSelection().getType().equals(Material.BARRIER)) {
                inventory.setItem(13, effectItemSlot.getEffectSelection());
            }
            else {
                inventory.setItem(indexForEffects++, effectItemSlot.getEffectSelection());
            }
        }
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

    public Material getIcon() {
        return categorySelection.getType();
    }

    public ItemStack getCategorySelection() {
        return categorySelection;
    }

    public List<EffectsItemSlot> getContents() {
        return contents;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
