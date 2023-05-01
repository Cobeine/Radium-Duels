package me.cynatix.radiumduels.arena;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.SerializationException;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerMoveEvent;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.function.Consumer;

/**
 * @author <a href="https://github.com/0Saturnine">0Saturnine</a>
 */
@Getter
@Setter
public class Position implements Serializable {
    private @Nullable Location location;

    private Position() {}


    public @Nullable Location get(){
        return location;
    }

    public Position set(Location location) {
        this.location = location;
        return this;
    }

    public static Position of(Location location) {
        return new Position().set(location);
    }

    /**
     * This method returns a position with fixed block alignments to the center
     * @param location entered location
     * @return fixed position
     */
    public static Position fixed(Location location) {
        Location fixedLocation = new Location(
                location.getWorld(), location.getBlockX() + .5, location.getBlockY(), location.getBlockZ() + .5,
                location.getYaw(), location.getPitch()
        );
        return of(fixedLocation);
    }
    HashMap<Class<? extends Event>, Consumer<? extends Event>> rules(){return null;}
    /**
     * Serializes a position into a HashMap<String,Object> for easy storage
     * @return the serialized position
     */
    public HashMap<String, Object> serialize() {
        HashMap<String, Object> ob = new HashMap<>();

        rules().put(PlayerMoveEvent.class,(Consumer<PlayerMoveEvent>) event -> {
        });

        if (location== null) {
            throw new SerializationException("Postition is not set!");
        }

        ob.put("world", location.getWorld().getName());
        ob.put("x", location.getX());
        ob.put("y", location.getY());
        ob.put("z", location.getZ());
        ob.put("yaw", location.getYaw());
        ob.put("pitch", location.getPitch());
        return ob;
    }

    /**
     * Converts already serialized position into position object
     * @param ob the serialized object
     * @return the new position instance
     */
    public static Position deserialize(HashMap<String,Object> ob){
        Location location = new Location(
                Bukkit.getWorld(ob.get("world").toString()),
                (double) ob.get("x"),
                (double) ob.get("y"),
                (double) ob.get("z"),
                (float) ob.get("yaw"),
                (float) ob.get("pitch")
        );
        return Position.of(location);
    }



}
