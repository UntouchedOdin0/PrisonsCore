package me.untouchedodin0.prisoncore;

public interface Module {

    void enable();

    void disable();

    void reload();

    boolean isEnabled();

    String getName();

    String getVersion();

    PrisonCore getPrisonCore();
}
