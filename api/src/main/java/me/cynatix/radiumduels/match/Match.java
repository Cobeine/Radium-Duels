package me.cynatix.radiumduels.match;

import me.cynatix.radiumduels.arena.Arena;
import org.jetbrains.annotations.NotNull;

/**
 * @author <a href="https://github.com/0Saturnine">0Saturnine</a>
 */

public class Match<K extends Enum<K>> {
    int time;
    @NotNull Arena arena;
    @NotNull MatchData<K> matchData;



}
