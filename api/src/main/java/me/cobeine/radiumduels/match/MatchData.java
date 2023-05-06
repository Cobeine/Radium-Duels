package me.cobeine.radiumduels.match;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;
import me.cobeine.radiumduels.arena.ArenaType;
import me.cobeine.radiumduels.queue.QueueType;
import me.cobeine.radiumduels.statistics.AbstractRecordPool;
import me.cobeine.radiumduels.user.IContender;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
@Getter
public class MatchData {
    private final @NotNull HashMap<IContender, AbstractRecordPool> recordPools;
    private final Date match_date;
    private final UUID matchUUID;
    @Setter
    private @NotNull String arenaName;
    @Setter
    private @NotNull QueueType type;
    @Setter
    private @NotNull ArenaType gameType;

    public MatchData() {
        this.recordPools = new HashMap<>();
        this.match_date = new Date();
        this.matchUUID = UUID.randomUUID();
    }

    public void saveAsFile() {
        Path.of("plugins/duels/match_history/").toFile().mkdirs();
        File file = new File("plugins/duels/match_history/", getMatchUUID() + ".json");
        try {
            file.createNewFile();
            JSONObject jsonObject = new JSONObject(recordPools);
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



