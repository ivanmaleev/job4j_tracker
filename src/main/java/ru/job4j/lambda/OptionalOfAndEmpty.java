package ru.job4j.lambda;

import java.util.List;
import java.util.Optional;

public class OptionalOfAndEmpty {
    public static Optional<String> findValue(List<String> strings, String value) {
        Optional<String> str = Optional.empty();
        int index = strings.indexOf(value);
        if (index != -1) {
            return Optional.of(strings.get(index));
        }
        return str;
    }
}