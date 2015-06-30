package me.mrconhd.Bungee.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.*;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Event;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.*;

/**
 * Created by Connor on 6/29/2015.
 */
public class List extends Command implements Listener {

    public List() {
        super("List", "firelight.list", "who");
    }

    ArrayList<String> mods = new ArrayList<String>();
    ArrayList<String> admins = new ArrayList<String>();
    ArrayList<String> devs = new ArrayList<String>();
    ArrayList<String> founders= new ArrayList<String>();

    String modsList;
    String adminsList;
    String devsList;
    String foundersList;


    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 0) {
            StringBuilder builder = new StringBuilder();
                for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
                    if (p.hasPermission("firelight.mod") && !mods.contains(p.getName())) {
                        mods.add(p.getName());
                    }
                    if (p.hasPermission("firelight.admin")) {// && !admins.contains(p.getName())) {
                        admins.add(p.getName());
                    }
                    if (p.hasPermission("firelight.dev")&& !devs.contains(p.getName())) {
                        devs.add(p.getName());
                    }
                    if (p.hasPermission("firelight.founder")&& !founders.contains(p.getName())) {
                        founders.add(p.getName());
                    }
                }
                    if (mods.isEmpty()) {
                    modsList = "NONE";
                    } else {
                     for (String name : mods) {
                        builder.append(", ").append(name);
                        name.replaceAll(", $","");
                         modsList = name;
                    }

                }

            if (admins.size() == 0) {
                adminsList = "NONE";
            } else {
                for (String name : admins) {
                    builder.append(", ").append(name);
                    name.replaceAll(", $", "");
                    adminsList = name;
                }
            }

            if (devs.isEmpty()) {
                devsList = "NONE";
            } else {
                for (String name : devs) {
                    builder.append(", ").append(name);
                    name.replaceAll(", $","");
                    devsList = name;
                }

            }

            if (founders.isEmpty()) {
                foundersList = "NONE";
            } else {
                for (String name : founders) {
                    builder.append(", ").append(name);
                    name.replaceAll(", $","");
                    foundersList = name;
                }

            }

            sender.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&c&lFirelight&6&lMC &7» &e&lONLINE STAFF MEMBERS\n" +
                    "&8============================\n" +
                    "&6&lFOUNDERS &7» &3" + foundersList + "\n" +
                    "&d&lDEVELOPERS &7» &3" + devsList + "\n" +
                    "&c&lADMINS &7» &3" + adminsList + "\n" +
                    "&b&lMODERATORS &7» &3" + modsList + "\n" +
                    "")));
        }
    }

    @EventHandler
    public void onQuit(PlayerDisconnectEvent e) {
        ProxiedPlayer p = e.getPlayer();
        if (admins.contains(p.getName())) {
            admins.remove(p.getName());
        }
    }

}
