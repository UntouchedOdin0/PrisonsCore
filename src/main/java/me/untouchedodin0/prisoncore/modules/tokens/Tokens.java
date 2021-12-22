package me.untouchedodin0.prisoncore.modules.tokens;

import me.untouchedodin0.prisoncore.Module;
import me.untouchedodin0.prisoncore.PrisonCore;

public class Tokens implements Module {

    public static final String MODULE_NAME = "Tokens";
    public static final String VERSION = "1.0";

    private PrisonCore prisonCore;
    private boolean enabled;

    public void enable() {
        this.enabled = true;
    }

    public void disable() {
        this.enabled = false;
    }

    @Override
    public void reload() {

    }

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String getName() {
        return MODULE_NAME;
    }

    @Override
    public String getVersion() {
        return VERSION;
    }

    public PrisonCore getPrisonCore() {
        return this.prisonCore;
    }
}
