package me.untouchedodin0.prisoncore.module;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import me.untouchedodin0.prisoncore.PrisonCore;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.lang.reflect.Field;
import java.util.logging.Logger;

@Getter
@Setter(AccessLevel.PACKAGE)
public class Module {

    private PrisonCore prisonCore;
    private static ModuleLoader moduleLoader = ModuleLoader.getInstance();

    private String name;
    private String author;
    private double version;
    private String[] dependencies;
    private File file;
    private String main;
    private File dataFolder;
    private File configFile;
    private FileConfiguration config;
    private Logger logger;

    public Module() {
        prisonCore = PrisonCore.getInstance();
        final Field bukkitCommandMap;
        try {
            bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
        } catch (NoSuchFieldException exception) {
            exception.printStackTrace();
        }
    }
}
