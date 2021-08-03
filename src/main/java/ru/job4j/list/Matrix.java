package ru.job4j.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {
    public static List<Integer> matrixToArray(Integer[][] matrix) {
        return Arrays.stream(matrix)
                .flatMap(e -> Arrays.stream(e))
                .collect(Collectors.toList());
    }
}
