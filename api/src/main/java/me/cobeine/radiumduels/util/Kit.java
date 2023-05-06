package me.cobeine.radiumduels.util;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

@Getter
public abstract class Kit {
    private final @NotNull ItemStack[] armor_contents;
    private final @NotNull HashMap<Integer, ItemStack> inventory;
    @Setter
    private String name;
    @Setter
    private boolean interactable;

    public Kit(){
        this.inventory = new HashMap<>();
        this.armor_contents = new ItemStack[4];
    }

    public void addItem(int slot,@NotNull ItemStack item) {
        inventory.put(slot,item);
    }

    public void equip(@NotNull Player player) {
        player.getInventory().setArmorContents(armor_contents);
        inventory.keySet().forEach(slot -> player.getInventory().setItem(slot,inventory.get(slot)));
    }

    public void give(@NotNull Player player) {
        player.getInventory().addItem(armor_contents);
        inventory.values().forEach(e -> player.getInventory().addItem(e));
    }

    public static @NotNull Kit cloneFromInventory(Player player) {
        Kit kit = new Kit() {};
        kit.armor_contents[0] = player.getInventory().getArmorContents()[0];
        kit.armor_contents[1] = player.getInventory().getArmorContents()[1];
        kit.armor_contents[2] = player.getInventory().getArmorContents()[2];
        kit.armor_contents[3] = player.getInventory().getArmorContents()[3];
        for (int slot =0; slot <= player.getInventory().getSize()-1; ){
            kit.addItem(slot,player.getInventory().getItem(slot));
            slot++;
        }
        return kit;
    }
}
