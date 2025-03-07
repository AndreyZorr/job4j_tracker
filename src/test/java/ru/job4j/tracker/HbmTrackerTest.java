package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HbmTrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenItemIsDeletedThenThereIsNoItem() {
        try (var tracker = new HbmTracker()) {
            var item = new Item();
            item.setName("test1");
            tracker.add(item);
            tracker.delete(item.getId());
            assertThat(tracker.findAll()).isEmpty();
        }
    }

    @Test
    public void whenReplace() {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item();
            Item item2 = new Item();
            item1.setName("test");
            item2.setName("test1");
            tracker.add(item1);
            tracker.add(item2);
            item2.setId(item1.getId());
            tracker.replace(item1.getId(), item2);
            Item result = tracker.findById(item1.getId());
            assertThat(result.getName()).isEqualTo(item1.getName());
        }
    }

    @Test
    public void whenAddTwoItemsThenReceiveTwoItems() {
        try (var tracker = new HbmTracker()) {
            var item1 = new Item();
            var item2 = new Item();
            item1.setName("test1");
            item2.setName("test2");
            tracker.add(item1);
            tracker.add(item2);
            assertThat(tracker.findAll()).usingRecursiveComparison()
                    .isEqualTo(List.of(item1, item2)
                    );
        }
    }

    @Test
    public void whenAddItemThenCanFindItByName() {
        try (var tracker = new HbmTracker()) {
            var item1 = new Item();
            item1.setName("test1");
            tracker.add(item1);
            assertThat(tracker.findByName(item1.getName())).isNotNull();
        }
    }

    @Test
    public void whenAddItemThenCanFindItById() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            assertThat(tracker.findById(item.getId())).usingRecursiveComparison()
                    .isEqualTo(item);
        }
    }

    @Test
    public void whenFailToReplaceItemThenReceiveFalse() {
        try (var tracker = new HbmTracker()) {
            var item = new Item();
            item.setName("test1");
            var result = tracker.replace(1, item);
            assertThat(result).isFalse();
        }
    }
}