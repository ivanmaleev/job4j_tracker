package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    public SimpleMap() {
        this.capacity = 8;
    }

    public SimpleMap(int capacity) {
        this.capacity = capacity;
        table = new MapEntry[capacity];
    }

    @Override
    public boolean put(K key, V value) {
        modCount++;
        int index = indexFor(hash(key.hashCode()));
        if (table[index] == null) {
            if (capacity * LOAD_FACTOR < (count + 1)) {
                expand();
            }
            table[index] = new MapEntry<>(key, value);
            count++;
        } else {
            if (table[index].value.equals(value)) {
                return false;
            }
            table[index].value = value;
        }
        return true;
    }

    private int hash(int hashCode) {
        return hashCode;
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        capacity = capacity * 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry<K, V> mapEntry : table) {
            if (mapEntry == null) {
                continue;
            }
            int index = indexFor(hash(mapEntry.key.hashCode()));
            newTable[index] = mapEntry;
        }
        modCount++;
        this.table = newTable;
    }

    @Override
    public V get(K key) {
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null) {
            return table[index].value;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null) {
            table[index] = null;
            modCount++;
            count--;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        Iterator<K> it = new Iterator<K>() {

            private int point = -1;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (int i = point + 1; i < capacity; i++) {
                    if (table[i] != null) {
                        point = i;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public K next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[point].key;
            }
        };
        return it;
    }

    private static class MapEntry<K, V> {

        private K key;
        private V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

}