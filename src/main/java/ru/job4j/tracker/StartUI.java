package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store store, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, store);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input input = new ValidateInput(out, new ConsoleInput());
        try (Store tracker = new SqlTracker()) {
            List<UserAction> actions = List.of(
                        new CreateAction(out),
                        new ExitAction(out),
                        new ShowAllAction(out),
                        new FindItemsNameAction(out),
                        new FindItemIdAction(out),
                        new DeleteAction(out),
                        new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }

        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(new CreateAction(out), new ShowAllAction(out),
                new EditAction(out), new DeleteAction(out), new FindItemIdAction(out),
                new FindItemsNameAction(out), new ExitAction(out));
        new StartUI(out).init(input, memTracker, actions);
    }
}
