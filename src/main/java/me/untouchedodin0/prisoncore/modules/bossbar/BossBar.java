package me.untouchedodin0.prisoncore.modules.bossbar;

import me.untouchedodin0.prisoncore.Module;
import me.untouchedodin0.prisoncore.PrisonCore;

public class BossBar implements Module {

    PrisonCore prisonCore;
    private static final String MODULE_NAME = "BossBar";
    private static final String VERSION = "1.0";

    public BossBar(PrisonCore prisonCore) {
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
