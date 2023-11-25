package net.daechler.instantinventory;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class InstantInventory extends JavaPlugin implements Listener {

    // Called when the plugin is enabled
    @Override
    public void onEnable() {
        // Register this class as an event listener
        getServer().getPluginManager().registerEvents(this, this);

        // Log a message indicating the plugin has been enabled
        getLogger().info(ChatColor.GREEN + getName() + " has been enabled!");
    }

    // Called when the plugin is disabled
    @Override
    public void onDisable() {
        // Log a message indicating the plugin has been disabled
        getLogger().info(ChatColor.RED + getName() + " has been disabled!");
    }

    // Event handler for when a block is broken
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        // Prevent the block from dropping items naturally
        event.setDropItems(false);

        // Create an ItemStack corresponding to the broken block
        ItemStack blockItem = new ItemStack(event.getBlock().getType());

        // Add the block to the player's inventory
        event.getPlayer().getInventory().addItem(blockItem);
    }
}
