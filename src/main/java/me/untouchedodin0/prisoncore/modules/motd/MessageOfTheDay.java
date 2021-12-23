package me.untouchedodin0.prisoncore.modules.motd;

import me.untouchedodin0.prisoncore.Module;
import me.untouchedodin0.prisoncore.PrisonCore;

public class MessageOfTheDay implements Module {

    PrisonCore prisonCore;
    private static final String MODULE_NAME = "Message of the Day";
    private static final String VERSION = "1.0";

    public MessageOfTheDay(PrisonCore prisonCore) {
        this.prisonCore = prisonCore;
    }

    @Override
    public void enable() {

    }

    @Override
    public void disable() {

    }

    @Override
    public void reload() {

    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getName() {
        return MODULE_NAME;
    }

    @Override
    public String getVersion() {
        return VERSION;
    }

    @Override
    public PrisonCore getPrisonCore() {
        return null;
    }
}
