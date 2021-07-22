package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i] == key) {
                return i;
            }
        }
        throw new ElementNotFoundException("Элемент не найден");
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[]{"fg", "sd", "yu"}, "rf");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
