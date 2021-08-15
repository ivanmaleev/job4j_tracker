package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int count = 0;

    public T poll() {
        for (int i = 0; i < count; i++) {
            out.push(in.pop());
        }
        T popReturn = out.pop();
        for (int i = 0; i < count - 1; i++) {
            in.push(out.pop());
        }
        count--;
        return popReturn;
    }

    public void push(T value) {
        count++;
        in.push(value);
    }
}