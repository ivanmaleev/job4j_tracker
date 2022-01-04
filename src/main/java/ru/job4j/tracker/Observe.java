package ru.job4j.tracker;

public interface Observe<T> {
    void receive(T model);
}