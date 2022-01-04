package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HbmTrackerTest {

    @Test
    public void whenAdd() {
        Store store = new HbmTracker();
        Item item = new Item("Item");
        item.setDescription("desc");
        Item add = store.add(item);
        assertThat(add.getId(), is(1));
        assertThat(add.getName(), is(item.getName()));
        assertThat(add.getDescription(), is(item.getDescription()));
    }

    @Test
    public void whenReplace() {
        Store store = new HbmTracker();
        Item item = new Item("Item");
        item.setDescription("desc");
        Item add = store.add(item);
        item.setName("Item2");
        assertTrue(store.replace(add.getId(), item));
    }

    @Test
    public void whenDelete() {
        Store store = new HbmTracker();
        Item item = new Item("Item");
        item.setDescription("desc");
        Item add = store.add(item);
        assertTrue(store.delete(add.getId()));
    }

    /* @Test
    public void whenFindAll() {
        Store store = new HbmTracker();
        Item item = new Item("Item");
        item.setDescription("desc");
        Item add = store.add(item);
        Item item2 = new Item("Item2");
        item.setDescription("desc2");
        Item add2 = store.add(item2);
        List<Item> list = List.of(add, add2);
        assertThat(store.findAll(), is(list));
    }*/

    @Test
    public void whenFindByName() {
        Store store = new HbmTracker();
        Item item = new Item("Item");
        item.setDescription("desc");
        Item add = store.add(item);
        assertThat(store.findByName("Item"), is(List.of(add)));
    }

    @Test
    public void whenFindById() {
        Store store = new HbmTracker();
        Item item = new Item("Item");
        item.setDescription("desc");
        Item add = store.add(item);
        assertThat(store.findById(add.getId()), is(add));
    }
}