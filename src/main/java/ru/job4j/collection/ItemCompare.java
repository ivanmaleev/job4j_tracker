package ru.job4j.collection;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.SortByNameItem;

import java.util.ArrayList;
import java.util.Collections;

public class ItemCompare {
    public static void main(String[] args) {

        ArrayList<Item> items = new ArrayList<>();

        Item item1 = new Item("Name");
        Item item2 = new Item("Home");
        Item item3 = new Item("Book");
        Item item4 = new Item("Phone");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        SortByNameItem comparatorItem = new SortByNameItem();
        Collections.sort(items, comparatorItem);
        for (Item item : items) {
            System.out.println(item);
        }
        Collections.sort(items, comparatorItem.reversed());
        for (Item item : items) {
            System.out.println(item);
        }
    }
}
