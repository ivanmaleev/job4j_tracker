package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        new Fact().calc(6);

    }

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Неверный параметр");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}