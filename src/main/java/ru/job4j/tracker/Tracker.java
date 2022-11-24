package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        int s = 0;
        Item[] rsl = new Item[size];
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item != null) {
                rsl[s++] = item;
            }
        }
        rsl = Arrays.copyOf(rsl, s);
        return rsl;
    }

    public Item[] findByName(String key) {
        int s = 0;
        Item[] rsl = new Item[size];
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (key.equals(item.getName())) {
                rsl[s++] = item;
            }
        }
        rsl = Arrays.copyOf(rsl, s);
        return rsl;
    }

    public boolean replace(int id, Item item) {
            if (indexOf(id) != -1) {
                int i = items[indexOf(id)].getId();
                items[indexOf(id)] = item;
                item.setId(i);
                return true;
            }
            return false;
    }
}