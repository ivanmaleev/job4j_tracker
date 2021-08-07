package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class SubList {
    public static List<String> getElementsBetweenIndexes(List<String> list, String el) {
        int count = 0;
        for (String str : list) {
            if (str.equals(el)) {
                count++;
            }
        }
        if (count == 0 || count == 1) {
            return new ArrayList<>();
        } else {
            return list.subList(list.indexOf(el), list.lastIndexOf(el));
        }
    }

}