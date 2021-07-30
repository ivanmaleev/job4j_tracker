package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] splitO1 = o1.split("/");
        String[] splitO2 = o2.split("/");
        if (!(splitO1.length == 1 && splitO2.length == 1)) {
            int minLength = Math.min(splitO1.length, splitO2.length);
            for (int i = 1; i < minLength; i++) {
                if (!splitO1[i].equals(splitO2[i])) {
                    return splitO1[i].compareTo(splitO2[i]);
                }
            }
            return o1.compareTo(o2);
        }
        return o2.compareTo(o1);
    }
}