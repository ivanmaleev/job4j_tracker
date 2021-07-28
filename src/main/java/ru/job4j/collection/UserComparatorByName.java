package ru.job4j.collection;

import java.util.Comparator;

public class UserComparatorByName implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        return user1.compareTo(user2);
    }
}
