package me.untouchedodin0.prisoncore;

import lombok.Getter;
import me.untouchedodin0.prisoncore.commands.Command;
import me.untouchedodin0.prisoncore.config.BossBarConfig;
import me.untouchedodin0.prisoncore.config.PrisonConfig;
import me.untouchedodin0.prisoncore.modules.motd.MessageOfTheDay;
import me.untouchedodin0.prisoncore.modules.motd.MessageOfTheDayListener;
import me.untouchedodin0.prisoncore.modules.ranks.Ranks;
import me.untouchedodin0.prisoncore.modules.tokens.Tokens;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import redempt.redlib.commandmanager.CommandParser;
import redempt.redlib.config.ConfigManager;

import java.util.LinkedHashMap;

public class PrisonCore extends JavaPlugin {

    private LinkedHashMap<String, Module> modules;
    private ConfigManager configManager;

    @Getter
    private static PrisonCore instance;

    @Getter
    private static PrisonConfig prisonConfig;

    @Getter
    private static BossBarConfig bossBarConfig;

    @Getter
    private Ranks ranks;

    @Getter
    private Tokens tokens;

    @Getter
    private MessageOfTheDay messageOfTheDay;

    @Override
    public void onEnable() {
        instance = this;
        prisonConfig = new PrisonConfig();
        bossBarConfig = new BossBarConfig(this);

        if (prisonConfig == null) {
            getLogger().info("prison config is null");
        }

        if (bossBarConfig == null) {
            getLogger().info("boss bar config is null");
        }

        this.modules = new LinkedHashMap<>();

        loadModule(new Ranks(this));
        loadModule(new Tokens(this));
        loadModule(new MessageOfTheDay(this));
        initModules();
        loadCommands();
        loadListeners();
        saveDefaultConfig();
        configManager = ConfigManager.create(this).target(PrisonConfig.class).load();

//        getLogger().info("Loaded " + bossBarConfig.getMessagesCount() + " boss bar messages!");
        getLogger().info(String.valueOf(bossBarConfig.getMessages()));
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
        this.ranks = new Ranks(this);
        this.tokens = new Tokens(this);
        this.messageOfTheDay = new MessageOfTheDay(this);

        this.modules.put(this.ranks.getName().toLowerCase(), this.ranks);
        this.modules.put(this.tokens.getName().toLowerCase(), this.tokens);
        this.modules.put(messageOfTheDay.getName().toLowerCase(), messageOfTheDay);
    }

    private void loadListeners() {
        this.getLogger().info("loading message of the day listener...");
        Bukkit.getServer().getPluginManager().registerEvents(new MessageOfTheDayListener(this), this);
    }

    private void loadCommands() {

        new CommandParser(this.getResource("command.rdcml"))
                .parse()
                .register("prisoncore",
                          new Command(this));
    }

    private void loadConfig(PrisonCore prisonCore) {

//        configManager = ConfigManager.create(this).target(PrisonConfig.class).saveDefaults().load();
    }
}
