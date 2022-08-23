package ru.dodabyte.beautifuleffects.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {

    private static ItemStack menuClock;

    public MenuItem() {
        menuClock = new ItemStack(Material.CLOCK);
        ItemMeta itemMeta = menuClock.getItemMeta();

        List<String> metaStringsList = new ArrayList<>();
        metaStringsList.add("");
        metaStringsList.add("Use this item to select an effect");
        metaStringsList.add("for the action you need.");

        itemMeta.setDisplayName(ChatColor.WHITE + "-- " + ChatColor.YELLOW +
                "Effects menu" + ChatColor.WHITE + " --");
        itemMeta.setLore(metaStringsList);

        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 36, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        menuClock.setItemMeta(itemMeta);
    }

    public static ItemStack getMenuItem() { return menuClock; }
}
