package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindItemIdActionTest {

    @Test
    public void whenFindItemIdAction() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Find item by id");
        tracker.add(item);
        FindItemIdAction findItemIdAction = new FindItemIdAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        findItemIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ===" + ln
                + item + ln
        );
    }
}