package me.mrconhd.Bungee;

import me.mrconhd.Bungee.commands.List;
import me.mrconhd.Bungee.commands.Locate;
import me.mrconhd.Bungee.commands.Staff;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * Created by Connor on 6/29/2015.
 */
public class Core extends Plugin {
    public void onEnable() {
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Staff());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Locate());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new List());
        this.getProxy().getPluginManager().registerListener(this, new List());
    }

}
