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
        Map<String, Integer> map = new SimpleMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        assertThat(map.get("Four"), is(4));
        assertThat(map.get("Two"), is(2));
        assertThat(map.get("Three"), is(4));
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
        Map<String, Integer> map = new SimpleMap<>(2);
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        map.put("Five", 5);
        map.put("Six", 6);
        map.put("Seven", 7);
        map.put("Eight", 8);
        map.put("Nine", 9);
        assertThat(map.get("Nine"), is(9));
        assertThat(map.get("Four"), is(6));
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