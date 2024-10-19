package org.nevermined.expansioncommand;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.nevermined.worldevents.api.WEApi;
import org.nevermined.worldevents.api.core.WorldEventAction;
import org.nevermined.worldevents.api.core.WorldEventApi;
import org.nevermined.worldevents.api.core.WorldEventManagerApi;
import org.nevermined.worldevents.api.core.WorldEventQueueApi;

public class CommandAction implements WorldEventAction {

    private final WorldEventManagerApi worldEventManager;

    public CommandAction() {
        this.worldEventManager = WEApi.getInstance().getWorldEventManager();
    }

    @Override
    public void startEvent(WorldEventApi worldEvent, WorldEventQueueApi queue) {
        ConfigurationSection config = worldEventManager.getEventConfiguration(queue.getQueueData().key(), worldEvent.getEventData().key());
        config.getStringList("start").forEach(cmd -> Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd));
    }

    @Override
    public void stopEvent(WorldEventApi worldEvent, WorldEventQueueApi queue) {
        ConfigurationSection config = worldEventManager.getEventConfiguration(queue.getQueueData().key(), worldEvent.getEventData().key());
        config.getStringList("stop").forEach(cmd -> Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd));
    }
}
