package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private int size = 0;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            T value = head.value;
            head = head.next;
            size--;
            return value;
        }
    }

    public boolean revert() {
        if (size == 0 || size == 1) {
            return false;
        }
        Node<T> current = head.next;
        head.next = null;
        Node<T> previous = head;
        for (int i = 1; i < size; i++) {
            Node<T> next = current.next;
            current.next = previous;
            if (next != null) {
                previous = current;
                current = next;
            } else {
                head = current;
            }
        }
        return true;
    }

    public void addFirst(T value) {
        head = new Node<>(value, head);
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}