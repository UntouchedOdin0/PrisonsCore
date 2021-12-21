package me.untouchedodin0.prisoncore.module;

import lombok.Getter;
import me.untouchedodin0.prisoncore.PrisonCore;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

// https://github.com/Langomatisch/Kiara/blob/master/core/src/main/java/de/mcgregordev/kiara/core/module/ModuleLoader.java

@Getter
public class ModuleLoader {

    @Getter
    private static ModuleLoader instance;

    private PrisonCore prisonCore;
    private Yaml yaml = new Yaml();
    private String path;
    private Map<String, Module> toLoad = new HashMap<>();
    private List<Module> loadedModules = new ArrayList<>();

    public ModuleLoader(String path) {
        long timeNow = System.currentTimeMillis();
        instance = this;
        this.path = path;
        this.prisonCore = PrisonCore.getInstance();

        boolean createdDirectories = new File(path).mkdirs();
        if (createdDirectories) {
            prisonCore.getLogger().info("Created the module directory!");
            loadModulesFromFolder();
            while (!toLoad.isEmpty()) {
                List<Module> toRemove = new ArrayList<>();
                for (Module module : toLoad.values()) {
                    module.onEnable();
                    loadedModules.add(module);
                    toRemove.add(module);
                }
                toRemove.forEach(module -> {
                    toLoad.remove(module.getName());
                });
            }
        }
        prisonCore.getLogger().info("Loaded " + loadedModules.size() + " modules in " + (System.currentTimeMillis() -1) + "ms");
    }

    private void loadModulesFromFolder() {
        for (File file : Objects.requireNonNull(new File(path).listFiles())) {
            if (file.getName().endsWith(".jar")) {
                try {
                    ZipFile javaFile = new ZipFile(file);
                    ZipEntry zipEntry = javaFile.getEntry("module.yml");
                    FileConfiguration config = YamlConfiguration.loadConfiguration(new InputStreamReader(javaFile.getInputStream(zipEntry)));
                    String main = config.getString("main");
                    Module module = loadIntoRunTime(file, main);
                    module.setName(config.getString("name"));
                    module.setAuthor(config.getString("author"));
                    module.setVersion(config.getDouble("version"));
                    module.setDependencies(config.getStringList("dependencies").toArray(new String[0]));
                    module.setFile(file.getParentFile());
                    module.setMain(main);
                    module.onLoad();
                    module.setupConfig();
                    toLoad.put(module.getName(), module);
                    javaFile.close();
                } catch (IOException | NoSuchMethodException | ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Module loadIntoRunTime(File file, String mainClass) throws NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException, MalformedURLException, InvocationTargetException {
        URLClassLoader urlClassLoader = (URLClassLoader) ModuleLoader.class.getClassLoader();
        Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
        addURL.setAccessible(true);
        addURL.invoke(urlClassLoader, file.toURI().toURL());
        Class<?> main = urlClassLoader.loadClass(mainClass);
        return (Module) main.newInstance();
    }
}
