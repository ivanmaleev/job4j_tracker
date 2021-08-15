package ru.job4j.list;

import java.util.*;

public class Alphabet {
    public static String reformat(String s) {
        String[] chars = s.split("");
        List<String> chars1 = Arrays.asList(chars);
        chars1.sort(String::compareTo);
        StringBuilder stringBuilder = new StringBuilder();
        for (String str:chars1) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}