package ru.dodabyte.beautifuleffects.menu.event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import ru.dodabyte.beautifuleffects.BeautifulEffectsMain;
import ru.dodabyte.beautifuleffects.effects.Effects;
import ru.dodabyte.beautifuleffects.effects.EffectsSelection;
import ru.dodabyte.beautifuleffects.menu.EffectsItemSlot;
import ru.dodabyte.beautifuleffects.menu.MenuSlot;

import java.util.UUID;

public class DragMenuItem implements Listener {

    @EventHandler
    public void onItemDrag(InventoryClickEvent event) {
        try {
            if (event.getInventory().getItem(45).getType() != Material.RED_STAINED_GLASS_PANE) {
                Player player = (Player) event.getWhoClicked();
                MenuSlot menuSlot = null;
                ItemStack clickedItem = event.getCurrentItem();

                if (clickedItem != null) {
                    for (MenuSlot ms : BeautifulEffectsMain.getEffectsMenu().getMenu()) {
                        if (ms.getIcon() == clickedItem.getType()) {
                            menuSlot = ms;
                            break;
                        }
                        else if (event.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE)) {
                            player.closeInventory();
                            player.openInventory(event.getInventory());
                        }
                    }

                    if (menuSlot != null) {
                        player.closeInventory();
                        player.openInventory(menuSlot.getInventory());
                    }
                }
            } else {
                Inventory inventory = event.getInventory();
                Player player = (Player) event.getWhoClicked();
                UUID playerUUID = player.getUniqueId();

                MenuSlot menuSlot = null;
                for (MenuSlot ms : BeautifulEffectsMain.getEffectsMenu().getMenu()) {
                    if (ms.getInventory() == inventory) {
                        menuSlot = ms;
                        break;
                    }
                }

                if (menuSlot != null) {
                    for (EffectsItemSlot tradeItemSlot : menuSlot.getContents()) {
                        if (tradeItemSlot.getEffectSelection().equals(event.getCurrentItem())) {
                            if (event.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE)) {
                                player.closeInventory();
                                player.openInventory(BeautifulEffectsMain.getEffectsMenu().getInventory());
                            }
                            else if (event.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE)) {
                                player.closeInventory();
                                player.openInventory(menuSlot.getInventory());
                            }
                            else if (menuSlot.getIcon().equals(Material.NETHERITE_SWORD)) {
                                EffectsSelection.setSelectedEffectMelee(playerUUID, Effects.getEffectsFromIcon(event.getCurrentItem().getType()));
                            }
                            else if (menuSlot.getIcon().equals(Material.BOW)) {
                                EffectsSelection.setSelectedEffectBow(playerUUID, Effects.getEffectsFromIcon(event.getCurrentItem().getType()));
                            }
                            break;
                        }
                    }

                    event.setCancelled(true);
                }
            }
        }
        catch (NullPointerException e) { System.out.println("Error: Type (material) item is null. "); }
    }
}
