package me.cobeine.radiumduels.spigot.managers;

import me.cobeine.radiumduels.arena.Arena;
import me.cobeine.radiumduels.arena.ArenaState;
import me.cobeine.radiumduels.core.IArenaManager;
import me.cobeine.radiumduels.exceptions.ArenaCreationException;
import me.cobeine.radiumduels.exceptions.ArenaGenerationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public class ArenaManager implements IArenaManager {
    private List<Arena> constants;
    private List<Arena> activeArenas;

    public ArenaManager() {
        this.constants = new ArrayList<>();
        this.activeArenas = new ArrayList<>();
    }



    @Nullable
    @Override
    public Arena generateNewArena(@NotNull Arena generatedFrom) throws ArenaGenerationException {
        return null;
    }

    @Nullable
    @Override
    public Arena generateRandomArena() throws ArenaGenerationException {
        return null;
    }

    @Override
    public @NotNull Arena createNewArena(Arena arena) throws ArenaCreationException {
        Optional<Arena> existant = constants().stream().filter(e -> e.getName().equalsIgnoreCase(arena.getName())).findAny();
        if (existant.isPresent()) {
            throw new ArenaCreationException(existant.get().getName(), ArenaCreationException.ExceptionCause.NAME_USED);
        }
        arena.createNewArena();
        arena.setState(ArenaState.INCOMPLETE);
        arena.createNewArena();
        constants().add(arena);
        return arena;
    }


    @Override
    public @NotNull List<Arena> constants() {
        return constants;
    }

    @Override
    public @NotNull List<Arena> getActiveArenas() {
        return activeArenas;
    }
}
