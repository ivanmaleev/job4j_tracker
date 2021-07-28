package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.collection.User;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void whenAsc() {
        Item item1 = new Item("Name");
        Item item2 = new Item("Home");
        Item item3 = new Item("Book");
        Item item4 = new Item("Phone");
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        List<Item> itemsEx = new ArrayList<>();
        itemsEx.add(item3);
        itemsEx.add(item2);
        itemsEx.add(item1);
        itemsEx.add(item4);

        SortByNameItem comparatorItem = new SortByNameItem();
        Collections.sort(items, comparatorItem);

        assertThat(items, is(itemsEx));
    }

    @Test
    public void whenDes() {
        Item item1 = new Item("Name");
        Item item2 = new Item("Home");
        Item item3 = new Item("Book");
        Item item4 = new Item("Phone");
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        List<Item> itemsEx = new ArrayList<>();
        itemsEx.add(item4);
        itemsEx.add(item1);
        itemsEx.add(item2);
        itemsEx.add(item3);

        SortByNameItemDes comparatorItem = new SortByNameItemDes();
        Collections.sort(items, comparatorItem);

        assertThat(items, is(itemsEx));
    }

}