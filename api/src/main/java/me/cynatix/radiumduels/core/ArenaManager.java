package me.cynatix.radiumduels.core;

import me.cynatix.radiumduels.arena.Arena;
import me.cynatix.radiumduels.exceptions.ArenaGenerationException;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author <a href="https://github.com/0Saturnine">0Saturnine</a>
 */

public interface ArenaManager {

    /**
     * constant arenas (aka templates) those are the ones to clone from
     * @return the list of arenas to clone
     */
    @NotNull List<Arena> constants();

    /**
     * The active arenas, the arenas are currently working and contains players
     * @return list of active arenas
     */

    @NotNull List<Arena> getActiveArenas();

    /**
     * This method generates a new arena from a constant arena (clones from template)
     * @param generatedFrom The constant arena
     * @return The new generated arena ready to use
     * @throws ArenaGenerationException if the `genratedFrom` arena is not a template
     */
    @Nullable
    Arena generateNewArena(@NotNull Arena generatedFrom) throws ArenaGenerationException;

    /**
     * This method generates a new random arena from the constants/templates
     * @return The new generated arena ready to use
     * @throws ArenaGenerationException if there's no constants
     */
    @Nullable
    Arena generateRandomArena() throws ArenaGenerationException;

    /**
     * This method creates a new constant arena and saves it and also returns it
     * @param arena the new constant arena
     * @return the same arena (if modifications needed after creation)
     */
    @NotNull
    Arena createNewArena(Arena arena);

}
