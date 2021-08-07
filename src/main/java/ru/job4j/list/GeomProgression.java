package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class GeomProgression {
    public static int generateAndSum(int first, int denominator, int count) {
        int sum = first;
        for (int i = 1; i < count; i++) {
            sum += first * (int) Math.pow(denominator, i);
        }
        return sum;
    }
}
