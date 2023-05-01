package me.cynatix.radiumduels.storage.local;

import me.cynatix.radiumduels.util.ReflectionUtil;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @author <a href="https://github.com/0Saturnine">0Saturnine</a>
 */

@SuppressWarnings("all")
public abstract class YamlFile {
    File file;
    FileConfiguration config;
    String name,path;
    public YamlFile(String name, String path) {

        this.name = name;
        this.path = path;
        this.file = new File(path, name + ".yml");

        if (!file.exists()){
            try {

                Bukkit.getLogger().info("File '" + name + ".yml' has been created");
                file.createNewFile();

            }catch (Exception e){
                Bukkit.getLogger().severe("Failed to create file '" + name + ".yml': " + e);
            }
            return;
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public void loadAndSave(Object clazz){
        load(clazz);
        save(clazz);
    }
    public void load(Object clazz) {
        //Loading
        if (file == null)
            this.file = new File(path, name + ".yml");
        if (config == null)
            config = YamlConfiguration.loadConfiguration(file);
        HashMap<Field, Object> fields = ReflectionUtil.getFields(clazz);
        for (Field field : fields.keySet()) {
            String pathInFile = field.getName().replace("_", ".");
            if (config.isSet(pathInFile)) {
                Object valueFromFile = config.get(pathInFile);
                ReflectionUtil.updateField(field, valueFromFile, clazz);
            }
        }
    }
    public void save(Object clazz){
        HashMap<Field, Object> fields = ReflectionUtil.getFields(clazz);
        for (Field f : fields.keySet()) {
            String path = f.getName().replace("_", ".");
            if (!config.isSet(path))
                config.set(path, fields.get(f));
        }
        save();
        fields.clear();
    }

    void save(){
        try{
            config.save(file);
        }catch (Exception e){
            Bukkit.getLogger().severe("Failed to save file '" + name + ".yml': " + e);
        }
    }

}