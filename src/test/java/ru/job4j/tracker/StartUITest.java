package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.Stub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class StartUITest {

    @Test
    public void whenCreate() {
        Output out = new Stub();
        MemTracker tracker = new MemTracker();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0", "Item name", "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new Create(out),
                new Exit(out))
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenEditItemTestOutputIsSuccessfully() {
        Output out = new Stub();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new Replace(out),
                new Exit(out))
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindIdItemTestOutputIsSuccessfully() {
        Output out = new Stub();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0", String.valueOf(one.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new FindById(out),
                new Exit(out))
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find item by ID" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by ID" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindNameItemTestOutputIsSuccessfully() {
        Output out = new Stub();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0", one.getName(), "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new FindByName(out),
                new Exit(out))
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find item by Name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by Name" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenShowAllItemsTestOutputSuccessfully() {
        Output out = new Stub();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new ru.job4j.tracker.input.Stub(new String[]{"0", "1"});
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new FindAll(out),
                new Exit(out))
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Show all Items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Show all Items" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenDelete() {
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new Delete(out),
                new Exit(out))
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenExit() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>(List.of(
                new Exit(out))
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu:" + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
                        + "=== Exit Program ===" + System.lineSeparator()
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"1", "0"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>(List.of(
                new Exit(out))
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 1" + ln
                        + "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        );
    }
}