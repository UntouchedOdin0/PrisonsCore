package me.untouchedodin0.prisoncore;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class PrisonCore extends JavaPlugin {

    @Getter
    private static PrisonCore instance;

    @Override
    public void onEnable() {
        instance = this;
    }
}
