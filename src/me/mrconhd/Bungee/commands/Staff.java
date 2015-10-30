package me.mrconhd.Bungee.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * Created by Connor on 6/29/2015.
 */
public class Staff extends Command {

    public Staff() {
        super("staff", "firelight.staffchat", "s");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length < 1) {
            sender.sendMessage(new TextComponent(ChatColor.DARK_RED + "/staff <message>"));
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < args.length; i++) {
            sb.append(args[i]).append(" ");
        }
        String msg = ChatColor.translateAlternateColorCodes('&', sb.toString().trim());

        for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
            if (player.hasPermission("firelight.staffchat")) {
                player.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&8[&4StaffChat&8] " + permissions.getRank() + "&b" + sender.getName() + " &8» &c" + msg)));
            }
        }

    }
}
