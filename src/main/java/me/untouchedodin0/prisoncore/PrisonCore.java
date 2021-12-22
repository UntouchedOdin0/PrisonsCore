package me.untouchedodin0.prisoncore;

import lombok.Getter;
import me.untouchedodin0.prisoncore.modules.ranks.Ranks;
import me.untouchedodin0.prisoncore.modules.tokens.Tokens;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.LinkedHashMap;

public class PrisonCore extends JavaPlugin {

    private LinkedHashMap<String, Module> modules;

    @Getter
    private static PrisonCore instance;

    @Getter
    private Ranks ranks;

    @Getter
    private Tokens tokens;

    @Override
    public void onEnable() {
        instance = this;
        this.modules = new LinkedHashMap<>();

        loadModule(new Ranks());
        loadModule(new Tokens());
        initModules();
    }

    @Override
    public void onDisable() {

    }

    public void loadModule(Module module) {
        if (module.isEnabled()) return;
        module.enable();
        instance.getLogger().info("Loading module " + module.getName() + " v" + module.getVersion());
    }

    private void initModules() {
        this.ranks = new Ranks();
        this.tokens = new Tokens();

        this.modules.put(this.ranks.getName().toLowerCase(), this.ranks);
        this.modules.put(this.tokens.getName().toLowerCase(), this.tokens);
    }
}
