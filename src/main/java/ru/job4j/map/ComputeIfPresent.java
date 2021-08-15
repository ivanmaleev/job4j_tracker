package ru.job4j.map;

import java.util.Map;
import java.util.Set;

public class ComputeIfPresent {
    public static Map<Integer, String> collectData(
            Map<Integer, String> name, Map<Integer, String> surname) {
        for (Map.Entry<Integer, String> entry: name.entrySet()) {
            name.computeIfPresent(entry.getKey(), (e, k) -> k + " " + surname.get(e));
        }
        return name;
    }
}
