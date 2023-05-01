package me.cynatix.radiumduels.util;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {
    public ItemStack stack;

    public ItemMeta meta;

    public ItemBuilder(Material mat, int id, int size) {
        this.stack = new ItemStack(mat, size, (byte)id);
        this.meta = this.stack.getItemMeta();
        addDefaultItemFlags();
    }
    public ItemBuilder(Material mat,int size) {
        this.stack = new ItemStack(mat, size);
        this.meta = this.stack.getItemMeta();
        addDefaultItemFlags();
    }
    public ItemBuilder(Material mat) {
        this.stack = new ItemStack(mat);
        this.meta = this.stack.getItemMeta();
    }

    public ItemBuilder(ItemStack s) {
        this.stack = s;
        this.meta = s.getItemMeta();
    }

    public static ItemBuilder potionBuilder(PotionType pot, int level, boolean splash) {
        Potion potion = new Potion(pot);
        potion.setSplash(splash);
        potion.setLevel(level);
        ItemStack s = potion.toItemStack(1);
        return new ItemBuilder(s);
    }

    public static ItemBuilder of(Material m) {
        return new ItemBuilder(m);
    }

    public ItemBuilder setDisplayName(String s) {
        this.meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',s));
        return this;
    }

    public ItemBuilder addLore(String s) {
        List<String> lore;
        if (this.meta.getLore() != null) {
            lore = this.meta.getLore();
        } else {
            lore = new ArrayList<>();
        }
        lore.add(ChatColor.translateAlternateColorCodes('&',s));
        this.meta.setLore(lore);
        return this;
    }

    public ItemBuilder setLore(List<String> l) {
        String[] array = l.toArray(new String[0]);
        return lore(array);
    }
    public List<String> getLore() {
        return this.meta.getLore();
    }



    public ItemBuilder lore(String... line) {
        List<String> lines = new ArrayList<>();
        for (String l : line) {
            lines.add(ChatColor.translateAlternateColorCodes('&',l));
        }
        this.meta.setLore(lines);
        return this;
    }

    public String getDisplayName() {
        return this.meta.getDisplayName();
    }

    public ItemBuilder addDefaultItemFlags() {
        this.meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        this.meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        this.meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        return this;
    }

    public ItemBuilder color(Color color) {
        if (this.stack.getType().toString().toLowerCase().contains("leather")) {
            LeatherArmorMeta a = (LeatherArmorMeta)this.meta;
            a.setColor(color);
            this.stack.setItemMeta(a);
        }
        return this;
    }

    public ItemBuilder skullOwner(String name) {
        if (this.meta instanceof SkullMeta){
            ((SkullMeta) this.meta).setOwner(name);
        }
        return this;
    }

    public ItemBuilder durability(int durability) {
        this.stack.setDurability((short)durability);
        return this;
    }

    public ItemStack build() {
        this.stack.setItemMeta(this.meta);
        return this.stack;
    }

    public ItemBuilder enchant(Enchantment e, int l) {
        meta.addEnchant(e, l, true);
        return this;
    }
}
