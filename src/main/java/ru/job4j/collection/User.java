package ru.job4j.collection;

import java.util.Objects;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(User anotherUser) {
        if (!this.name.equals(anotherUser.getName())) {
            return this.age > anotherUser.getAge() ? 1 : -1;
        }
        return this.name.compareTo(anotherUser.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.getAge()
                && Objects.equals(name, user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}