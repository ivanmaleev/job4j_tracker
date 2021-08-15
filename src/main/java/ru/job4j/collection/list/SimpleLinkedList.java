package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {

    private int size = 0;
    private int modCount = 0;
    private Node<E> firstNode;
    private Node<E> lastNode;

    private static class Node<E> {
        private E value;
        private Node<E> next;
        private Node<E> prev;

        public Node(E value, Node<E> next, Node<E> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void add(E value) {
        Node<E> newNode = new Node<>(value, null, lastNode);
        if (lastNode == null) {
            firstNode = newNode;
        } else {
            lastNode.next = newNode;
        }
        lastNode = newNode;
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        int i = Objects.checkIndex(index, size);
        Node<E> returnNode = firstNode;
        for (int j = 1; j <= i; j++) {
            returnNode = returnNode.next;
        }
        return returnNode.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            private Node<E> pointNode;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (pointNode == null) {
                    return firstNode != null;
                }
                return pointNode.next != null;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (pointNode == null) {
                    pointNode = firstNode;
                } else {
                    pointNode = pointNode.next;
                }
                return pointNode.value;
            }
        };
    }
}