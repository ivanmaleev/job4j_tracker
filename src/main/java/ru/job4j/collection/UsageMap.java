package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mail@mail.ru", "Ivan");
        for (String key : hashMap.keySet()) {
            System.out.println(hashMap.get(key));
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
