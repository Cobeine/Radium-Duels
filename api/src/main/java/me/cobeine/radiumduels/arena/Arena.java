package me.cobeine.radiumduels.arena;

import me.cobeine.radiumduels.exceptions.ArenaJoinException;
import me.cobeine.radiumduels.exceptions.ArenaLeaveException;
import me.cobeine.radiumduels.user.Contender;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public interface Arena extends Cloneable, Serializable, Comparable<Arena> {

    /**
     * @return The arena's name in storage.
     */
    String getName();
                                                                           
    /**
     * The title all players can see
     * @return The display name of the arena in the front-end
     */
    String getTitle();

    /**
     * Those are the positions where can players get teleported to within the Arena
     * @Returns list of playable positions
     */
    List<Position> getPositions();


        /**
     * The center of the arena, can also be used for player teleportation for a specific types of games (FFA)
     * Can also be used for spawn location in events
     * @return the center
     */
    Position getCenter();


   // HashMap<Class<? extends Event>, Consumer<? extends Event>> rules();

        /**
     * The amount of players the arena can hold.
     * Related to the amount of available positions.
     * @return amount of players the arena can handle
     */
    default int size(){
        return getPositions().size();
    }

    /**
     * This boolean is specifically made for arenas that allows to build/interact with.
     * @return true if the arena is interactable
     */
    boolean isInteractable();

    void addContender(Contender contender) throws ArenaJoinException;

    void removeContender(Contender contender) throws ArenaLeaveException;

    /**
     * @returns the type of the arena
     */
    ArenaType getType();


    /**
     * serializes an arena for easy storage
     * @return serialized arena
     */
    default HashMap<String, Object> serialize() {
        HashMap<String, Object> ob = new HashMap<>();
        ob.put("center", getCenter());
        ob.put("poses", getPositions());
        ob.put("name", getName());
        ob.put("title", getTitle());
        ob.put("type", getType());
        return ob;
    }

    void createNewArena();

    void setState(ArenaState incomplete);


    enum ArenaLeaveReason {
        MATCH_ENDED,CONTENDER_QUIT,SERVER_RESTART
    }

}

