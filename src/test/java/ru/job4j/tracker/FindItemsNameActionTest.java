package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindItemsNameActionTest {

    @Test
    public void whenFindItemsNameAction() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        String findName = "Find items by name";
        String name = "Enter name";
        Item item = new Item(findName);
        tracker.add(item);
        FindItemsNameAction findItemsNameAction = new FindItemsNameAction(output);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(name);
        findItemsNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo("=== Find items by name ===" + ln
        + "Заявки с именем: " + name + " не найдены." + ln);
    }
}