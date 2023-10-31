package ru.job4j.tracker;

import java.util.List;

public class FindItemsNameAction implements UserAction {
    private final Output out;

    public FindItemsNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Enter name";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        List<Item> items = store.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Заявки с именем: " + name + " не найдены.");
    }
        return true;
    }
}



