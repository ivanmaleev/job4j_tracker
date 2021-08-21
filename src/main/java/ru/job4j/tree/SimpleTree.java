package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> childNode = findBy(child);
        if (childNode.isPresent()) {
            return false;
        }
        Optional<Node<E>> parentNode = findBy(parent);
        if (!parentNode.isPresent()) {
            return false;
        }
        parentNode.get().getChildren().add(new Node<>(child));
        return true;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> returnNode = findByPredicate(node -> node.getValue().equals(value));
        return returnNode;
    }

    @Override
    public boolean isBinary() {
        Optional<Node<E>> notBinaryNode = findByPredicate(node -> node.getChildren().size() > 2);
        return !notBinaryNode.isPresent();
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.getChildren());
        }
        return rsl;
    }
}