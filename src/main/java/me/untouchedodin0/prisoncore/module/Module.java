package me.untouchedodin0.prisoncore.module;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import me.untouchedodin0.prisoncore.PrisonCore;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
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
    private CommandMap commandMap;

    public Module() {
        prisonCore = PrisonCore.getInstance();
        final Field bukkitCommandMap;
        try {
            bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            bukkitCommandMap.setAccessible(true);
            commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());
        } catch (NoSuchFieldException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
        this.logger = Logger.getLogger(getName());
    }

    void setupConfig() {
        dataFolder = new File(file, name);
        boolean created = dataFolder.mkdirs();

        System.out.println("dataFolder: " + dataFolder);
        configFile = new File(dataFolder, "config.yml");
        try {
            boolean createdFile = configFile.createNewFile();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public void saveConfig() {
        try {
            config.save(configFile);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /*
     *  This will be called when the module is enabled
     */

    public void onEnable() {

    }

    /*
        This will be called when the module gets disabled
     */

    public void onDisable() {

    }

    /*
        This will be called when the module first gets loaded
     */

    public void onLoad() {

    }
}