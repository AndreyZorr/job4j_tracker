package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                result.add(item);
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
        }
        return result;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
        }
    }

    public void deleteAll() {
            items.clear();
        }

    public void close() throws Exception {
    }
}