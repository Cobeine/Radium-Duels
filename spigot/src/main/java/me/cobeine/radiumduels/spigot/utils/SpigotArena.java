package me.cobeine.radiumduels.spigot.utils;

import lombok.Getter;
import lombok.Setter;
import me.cobeine.radiumduels.arena.Arena;
import me.cobeine.radiumduels.arena.ArenaState;
import me.cobeine.radiumduels.arena.ArenaType;
import me.cobeine.radiumduels.arena.Position;
import me.cobeine.radiumduels.exceptions.ArenaJoinException;
import me.cobeine.radiumduels.exceptions.ArenaLeaveException;
import me.cobeine.radiumduels.spigot.Core;
import me.cobeine.radiumduels.storage.local.JsonFile;
import me.cobeine.radiumduels.user.Contender;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
@Getter
public class SpigotArena extends JsonFile implements Arena{

    private String name,title;
    private List<Position> positions;
    private Position center;
    private ArenaType type;
    private @Setter ArenaState state;
    private @Setter boolean interactable;

    public SpigotArena(String name) {
        super(name, Core.getInstance().getDataFolder().getPath() + "/Arenas",false);
        this.name = name;
        this.state = ArenaState.INCOMPLETE;

    }
    public SpigotArena(String name,ArenaType type) {
        this(name);
        this.type = type;
    }

    public SpigotArena(String name, ArenaType type, ArenaWand wand) {
        this(name,type);
        this.positions = wand.getPositions();
        this.center = wand.getCenter();
    }

    @Override
    public void save() {
        setJsonObject(new JSONObject(this.serialize()));
        super.save();
    }


    @Override
    public void addContender(Contender contender) throws ArenaJoinException {

    }

    @Override
    public void removeContender(Contender contender) throws ArenaLeaveException {

    }

    @Override
    public void createNewArena() {
        save();
    }


    @Override
    public int compareTo(@NotNull Arena o) {
        return 0;
    }

    @Override
    public void setDefaults() {

    }
}
