package me.cynatix.radiumduels.match;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;
import me.cynatix.radiumduels.arena.ArenaType;
import me.cynatix.radiumduels.queue.QueueType;
import me.cynatix.radiumduels.user.Contender;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author <a href="https://github.com/0Saturnine">0Saturnine</a>
 */
@Getter
public class MatchData<K extends Enum<K>> {
    private final @NotNull HashMap<Contender, List<Record<K>>> records;
    private final Date match_date;
    private final UUID matchUUID;
    @Setter
    private @NotNull String arenaName;
    @Setter
    private @NotNull QueueType type;
    @Setter
    private @NotNull ArenaType gameType;

    public MatchData() {
        this.records = new HashMap<>();
        this.match_date = new Date();
        this.matchUUID = UUID.randomUUID();
    }

    public void saveAsFile() {
        Path.of("plugins/duels/match_history/").toFile().mkdirs();
        File file = new File("plugins/duels/match_history/", getMatchUUID() + ".json");
        try {
            file.createNewFile();
            JSONObject jsonObject = new JSONObject(records);
            try (FileWriter fileWriter = new FileWriter(file.getPath())){
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(jsonObject,fileWriter);
                fileWriter.flush();
            } catch (IOException e) {
                Bukkit.getLogger().severe("failed to save match " + matchUUID + ".json: " + e);
            }
        } catch (Exception ignored) {
        }
    }
}



