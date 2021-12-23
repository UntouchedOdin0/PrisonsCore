package me.untouchedodin0.prisoncore.modules.motd;

import me.untouchedodin0.prisoncore.PrisonCore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MessageOfTheDayListener implements Listener {

    private PrisonCore prisonCore;

    public MessageOfTheDayListener(PrisonCore prisonCore) {
        this.prisonCore = prisonCore;
    }

    MessageOfTheDay messageOfTheDay = new MessageOfTheDay(prisonCore);

    @EventHandler
    public void onPing(ServerListPingEvent serverListPingEvent) {
        prisonCore.getLogger().info(serverListPingEvent.getMotd());
        prisonCore.getLogger().info(serverListPingEvent.getAddress().toString());
        prisonCore.getLogger().info(String.valueOf(serverListPingEvent.getMaxPlayers()));
        prisonCore.getLogger().info(String.valueOf(serverListPingEvent.getNumPlayers()));
    }
}
