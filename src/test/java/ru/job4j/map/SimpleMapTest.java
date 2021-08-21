package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleMapTest {

    @Test
    public void putGet() {
        Map<Integer, Integer> map = new SimpleMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        assertThat(map.get(4), is(4));
        assertThat(map.get(2), is(2));
        assertThat(map.get(3), is(3));
    }

    @Test
    public void remove() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        map.remove("Four");
        assertNull(map.get("Four"));
    }

    @Test
    public void expand() {
        Map<Integer, Integer> map = new SimpleMap<>(8);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.put(7, 7);
        map.put(8, 8);
        map.put(9, 9);
        assertThat(map.get(9), is(9));
        assertThat(map.get(6), is(6));
    }

    @Test
    public void bigArray() {
        Map<String, Integer> map = new SimpleMap<>(256);
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Fourd", 4);
        map.put("Fivev", 5);
        map.put("Six", 6);
        map.put("Seven", 7);
        map.put("Eight", 8);
        map.put("Nine", 9);
        assertThat(map.get("One"), is(1));
        assertThat(map.get("Two"), is(2));
        assertThat(map.get("Three"), is(3));
        assertThat(map.get("Fourd"), is(4));
        assertThat(map.get("Fivev"), is(5));
    }

    @Test
    public void iteratorHasNext() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        Iterator<String> iterator = map.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void iteratorNext() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        Iterator<String> iterator = map.iterator();
        assertThat(iterator.next(), is("Two"));
        assertThat(iterator.next(), is("One"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
            Map<String, Integer> map = new SimpleMap<>();
            map.put("One", 1);
            map.put("Two", 2);
            Iterator<String> iterator = map.iterator();
            iterator.next();
            iterator.next();
            iterator.next();
    }
}