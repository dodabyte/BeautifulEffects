package ru.dodabyte.beautifuleffects.menu;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class EffectsItemSlot {
    private ItemStack effectSelection;
    private String name;

    public EffectsItemSlot(ItemStack itemForEffect, String name, String effectDescription) {
        this.effectSelection = itemForEffect;
        this.name = name;
        List<String> lore = Arrays.asList(
                "",
                effectDescription
        );

        ItemMeta itemMeta = this.effectSelection.getItemMeta();
        itemMeta.setLore(lore);
        itemMeta.setDisplayName(name);
        this.effectSelection.setItemMeta(itemMeta);
    }

    public EffectsItemSlot(ItemStack itemForEffect, String name) {
        this.effectSelection = itemForEffect;
        this.name = name;

        ItemMeta itemMeta = this.effectSelection.getItemMeta();
        itemMeta.setDisplayName(name);
        effectSelection.setItemMeta(itemMeta);
    }

    public ItemStack getEffectSelection() { return effectSelection; }

    public String getName() {
        return name;
    }
}
