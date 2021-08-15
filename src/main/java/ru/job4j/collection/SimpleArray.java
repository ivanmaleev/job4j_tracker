package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] container;
    private int size = 0;
    private int modCount = 0;

    public SimpleArray(int length) {
        this.container = new Object[length];
    }

    public SimpleArray() {
        this.container = new Object[10];
    }

    private void grow() {
        int newSize = size * 2;
        Object[] newContainer = new Object[newSize];
        System.arraycopy(container, 0, newContainer, 0, size);
        this.container = newContainer;
    }

    public void add(T model) {
        //int i = Objects.checkIndex(size, container.length);
        modCount++;
        if (size == container.length) {
            grow();
        }
        size++;
        container[size - 1] = model;
    }

    public void set(int index, T model) {
        int i = Objects.checkIndex(index, size);
        modCount++;
        container[i] = model;
    }

    public void remove(int index) {
        int i = Objects.checkIndex(index, size);
        modCount++;
        size--;
        System.arraycopy(container, i + 1, container, i, container.length - index - 1);
        container[size] = null;
    }

    public T get(int index) {
        int i = Objects.checkIndex(index, size);
        return (T) container[i];
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int point = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point < size;
            }

            @Override
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[point++];
            }
        };
        return it;
    }
}
