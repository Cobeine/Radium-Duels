package me.cobeine.radiumduels.arena;

import me.cobeine.radiumduels.user.IContender;
import me.cobeine.radiumduels.exceptions.ArenaJoinException;
import me.cobeine.radiumduels.exceptions.ArenaLeaveException;
import org.bukkit.event.Event;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public interface Arena extends Cloneable, Serializable, Comparable<Arena> {

    /**
     * @return The arena's name in storage.
     */
    String name();
                                                                           
    /**
     * The title all players can see
     * @return The display name of the arena in the front-end
     */
    String title();

    /**
     * Those are the positions where can players get teleported to within the Arena
     * @Returns list of playable positions
     */
    List<Position> positions();


        /**
     * The center of the arena, can also be used for player teleportation for a specific types of games (FFA)
     * Can also be used for spawn location in events
     * @return the center
     */
    Position center();


    HashMap<Class<? extends Event>, Consumer<? extends Event>> rules();

        /**
     * The amount of players the arena can hold.
     * Related to the amount of available positions.
     * @return amount of players the arena can handle
     */
    default int size(){
        return positions().size();
    }

    /**
     * This boolean is specifically made for arenas that allows to build/interact with.
     * @return true if the arena is interactable
     */
    boolean interactable();

    void addContender(IContender contender) throws ArenaJoinException;

    void removeContender(IContender contender) throws ArenaLeaveException;

    /**
     * @returns the type of the arena
     */
    ArenaType type();


    /**
     * serializes an arena for easy storage
     * @return serialized arena
     */
    default HashMap<String, Object> serialize() {
        HashMap<String, Object> ob = new HashMap<>();
        ob.put("center", center());
        ob.put("poses", positions());
        ob.put("name", name());
        ob.put("title", title());
        ob.put("type", type());
        return ob;
    }
    

     enum ArenaLeaveReason {
        MATCH_ENDED,CONTENDER_QUIT,SERVER_RESTART
    }

}

