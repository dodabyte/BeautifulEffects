package ru.dodabyte.beautifuleffects.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import ru.dodabyte.beautifuleffects.BeautifulEffectsMain;
import ru.dodabyte.beautifuleffects.items.MenuItem;

import java.util.Objects;

public class GeneralCommands implements CommandExecutor {

    public GeneralCommands(BeautifulEffectsMain plugin) {
        Objects.requireNonNull(plugin.getCommand("beautifuleffects")).setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            System.out.println("Only a player can use this command.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 1) {
            printHelp(player);
            return true;
        }

        if (args[0].equalsIgnoreCase("help")) {
            printHelp(player);
            return true;
        }
        else if (args[0].equalsIgnoreCase("menu")) {
            player.openInventory(BeautifulEffectsMain.getEffectsMenu().getInventory());
            return true;
        }
        else if (args[0].equalsIgnoreCase("menuitem")) {
            ItemStack menuClock = MenuItem.getMenuItem();
            player.getInventory().addItem(menuClock);
            return true;
        }
        else {
            printHelp(player);
            return true;
        }
    }

    private void printHelp(Player player) {
        String message = ChatColor.YELLOW + "--------- " + ChatColor.WHITE + "BeautifulEffects Help" +
                ChatColor.YELLOW + " ---------\n" +
                ChatColor.GOLD + "/beautifuleffects help: " + ChatColor.WHITE + "Calling help to the plugin.\n" +
                ChatColor.GOLD + "/beautifuleffects menu: " + ChatColor.WHITE + "Opening the plugin menu.\n" +
                ChatColor.GOLD + "/beautifuleffects menuitem: " + ChatColor.WHITE + "Give an item to open the menu.\n";
        player.sendMessage(message);
    }
}
