package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        int totalSum = 0;
        for (int num : number) {
            totalSum += add(() -> total + num);
        }
        System.out.println(totalSum);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}