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
public class Locate extends Command {

    public Locate()
    {
        super("locate", "firelight.locate", "l");
    }


    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 0) {
            ProxiedPlayer p = ProxyServer.getInstance().getPlayer(args[0]);
            if (!p.equals(null)) {
                sender.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&8[&cFirelight&6MC&8] &e" + p.getName() + " &8is currently located at &e" + p.getServer().getInfo().getName())));
            }
        }
    }
}
