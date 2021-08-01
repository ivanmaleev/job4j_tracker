package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CalcFunctions {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        ArrayList<Double> doubleArrayList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            doubleArrayList.add(func.apply((double) i));
        }
        return doubleArrayList;
    }
}
