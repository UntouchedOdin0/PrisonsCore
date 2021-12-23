package me.untouchedodin0.prisoncore.modules.bossbar;

import me.untouchedodin0.prisoncore.Module;
import me.untouchedodin0.prisoncore.PrisonCore;

public class BossBar implements Module {

    PrisonCore prisonCore;

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
        return null;
    }

    @Override
    public String getVersion() {
        return null;
    }

    @Override
    public PrisonCore getPrisonCore() {
        return null;
    }
}
