package ru.job4j.list;

import java.util.List;

public class Factory {
    public static void main(String[] args) {
        List<String> list = List.of("first", "second", "third", "fourth", "fifth");
        for (String el: list) {
            System.out.println(el);
        }
    }
}