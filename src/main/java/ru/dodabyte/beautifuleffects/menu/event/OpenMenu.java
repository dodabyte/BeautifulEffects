package ru.dodabyte.beautifuleffects.menu.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import ru.dodabyte.beautifuleffects.BeautifulEffectsMain;
import ru.dodabyte.beautifuleffects.items.MenuItem;

public class OpenMenu implements Listener {

    @EventHandler
    public void onMenuItemClicked(PlayerInteractEvent event) {
        ItemStack itemStack = event.getPlayer().getInventory().getItemInMainHand();

        if (itemStack.isSimilar(MenuItem.getMenuItem())) {
            event.getPlayer().openInventory(BeautifulEffectsMain.getEffectsMenu().getInventory());
        }
    }
}
