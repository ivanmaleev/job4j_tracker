package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayStream {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(2);
        array.add(-5);
        array.add(6);
        array.add(-7);
        array.add(10);
        List<Integer> posList = array.stream().filter(element -> element > 1)
                .collect(Collectors.toList());
        posList.forEach(System.out::println);
    }
}
