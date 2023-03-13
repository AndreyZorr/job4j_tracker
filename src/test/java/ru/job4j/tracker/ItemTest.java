package ru.job4j.tracker;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {

    @Test
    public void whenTestItemDescByName() {
        List<Item> item = Arrays.asList(
                new Item(5, "Fix bugs"),
                new Item(1, "Impl task"),
                new Item(4, "Reboot server")
        );
        List<Item> exp = new ArrayList<>();
        exp.add(item.get(2));
        exp.add(item.get(1));
        exp.add(item.get(0));
        item.sort(new ItemDescByName());
        assertThat(item).isEqualTo(exp);
    }

    @Test
    public void whenTestItemAscByName() {
        List<Item> item = Arrays.asList(
                new Item(5, "Fix bugs"),
                new Item(4, "Reboot server"),
                new Item(1, "Impl task")
        );
        List<Item> exp = new ArrayList<>();
        exp.add(item.get(0));
        exp.add(item.get(2));
        exp.add(item.get(1));
        item.sort(new ItemAscByName());
        assertThat(item).isEqualTo(exp);
    }
}