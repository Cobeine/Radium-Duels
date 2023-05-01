package me.cynatix.radiumduels.arena;

/**
 * @author <a href="https://github.com/0Saturnine">0Saturnine</a>
 */
public enum ArenaType {


    /**
     * ArenaType.FLAT arenas are the most common one (2 positions and center)
     */
    FLAT,
    /**
     * ArenaType.TOURNAMENT arenas are the ones that are used to hold tournaments (multiple positions, one center, and different datasets)
     */
    TOURNAMENT,
    /**
     * ArenaType.EVENT arenas are the same as TOURNAMENT but less complex.
     */
    EVENT,
    /**
     * ArenaType.SUMO same as FLAT except for the match ending & settings in general.
     */
    SUMO


}
