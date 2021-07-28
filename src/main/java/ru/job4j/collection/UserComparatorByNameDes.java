package ru.job4j.collection;

import java.util.Comparator;

public class UserComparatorByNameDes implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        return user2.compareTo(user1);
    }
}
