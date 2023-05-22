package me.cobeine.radiumduels.storage.local;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public abstract class JsonFile {
    final File file;
    final String name;
    @Setter JSONObject jsonObject;
    public JsonFile(String name, String path,boolean autoCreate) {
        Path.of(path).toFile().mkdirs();
        this.file = new File(path, name + ".json");
        this.name = name;
        try {
            jsonObject = new JSONObject();
            if (autoCreate)
                if (!file.exists()) {
                    file.createNewFile();
                    setDefaults();
                    save();
                    return;
                }
            load();
        } catch (Exception e) {
            Bukkit.getLogger().severe("failed to create/load file " + name + ".json: " + e);
        }
    }


    public void save(){
        try (FileWriter fileWriter = new FileWriter(file.getPath())){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(jsonObject,fileWriter);
            fileWriter.flush();
        } catch (IOException e) {
             Bukkit.getLogger().severe("failed to save file " + name + ".json: " + e);
        }
    }
    private void load() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(file.getPath())) {
            Object obj = jsonParser.parse(reader);
            this.jsonObject = (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
             Bukkit.getLogger().severe("failed to load file " + name + ".json: " +e );
        }
    }

    public JSONObject get() {
        return jsonObject;
    }

    public abstract void setDefaults();
}
