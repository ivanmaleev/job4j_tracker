package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        MemTracker memTracker = new MemTracker();
        Output output = new ConsoleOutput();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        MemTracker memTracker = new MemTracker();
        Output output = new ConsoleOutput();
        Item item = memTracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        MemTracker memTracker = new MemTracker();
        Output output = new ConsoleOutput();
        Item item = memTracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() + "0. Exit Program" + System.lineSeparator()
        ));
    }

    /*
    @Test
    public void findAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("New item"));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Show all items ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
        ));
    }*/

    @Test
    public void findByNameAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "New item", "1"}
        );
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("New item"));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Find items by name ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()

        ));
    }

    @Test
    public void findByIdAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("New item"));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIDAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Find item by id ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()

        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"10", "0"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit Program" + ln
                )
        );
    }

    @Test
    public void whenDeleteItemMok() {
        MemTracker memTracker = new MemTracker();
        Output output = new ConsoleOutput();
        Item item = memTracker.add(new Item("Deleted item"));
        Input in = mock(Input.class);
        when(in.askInt(any(String.class))).thenReturn(0).thenReturn(1);
        when(in.askStr(any(String.class))).thenReturn("" + item.getId());
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void findByNameActionMok() {
        Output out = new StubOutput();
        Input in = mock(Input.class);
        when(in.askInt(any(String.class))).thenReturn(0).thenReturn(1);
        when(in.askStr(any(String.class))).thenReturn("New item");
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("New item"));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Find items by name ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()

        ));
    }

    @Test
    public void findByIdActionMok() {
        Output out = new StubOutput();
        Input in = mock(Input.class);
        when(in.askInt(any(String.class))).thenReturn(0).thenReturn(1);
        when(in.askStr(any(String.class))).thenReturn("1");
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("New item"));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIDAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Find item by id ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()

        ));
    }
}