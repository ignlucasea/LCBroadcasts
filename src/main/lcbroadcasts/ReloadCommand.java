package com.spaleforce.lcbroadcasts;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {

    private final LCBroadcasts plugin;

    public ReloadCommand(LCBroadcasts plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Usage: /lcbroadcast reload");
            return true;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("autobroadcast.reload")) {
                sender.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
                return true;
            }

            plugin.reload();
            sender.sendMessage(ChatColor.GREEN + "LCBroadcasts configuration reloaded successfully!");
            sender.sendMessage(ChatColor.YELLOW + "Loaded " + plugin.getMessages().size() + " messages.");
            sender.sendMessage(ChatColor.YELLOW + "Interval: " + plugin.getIntervalSeconds() + " seconds");
            sender.sendMessage(ChatColor.YELLOW + "Random order: " + plugin.isRandomOrder());
            return true;
        }

        sender.sendMessage(ChatColor.RED + "Unknown subcommand. Use: /lcbroadcast reload");
        return true;
    }
}
