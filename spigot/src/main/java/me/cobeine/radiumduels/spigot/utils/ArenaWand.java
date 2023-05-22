package me.cobeine.radiumduels.spigot.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.cobeine.radiumduels.arena.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
@AllArgsConstructor(staticName = "of")
@Getter
public class ArenaWand {
    private List<Position> positions;
    private @Setter @Getter Position center;

    @Getter private static final HashMap<UUID, ArenaWand> wands = new HashMap<>();


    public static ArenaWand empty() {
        return ArenaWand.of(new ArrayList<>(), null);
    }

    public boolean isComplete() {
        return getPositions().size() >= 2 && center != null;
    }
}
