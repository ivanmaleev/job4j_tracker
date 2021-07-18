package ru.job4j.oop;

public class Builder extends Engineer {
    private String direction;

    public Builder(String name, String surName, String education, String birthday, String direction) {
        super(name, surName, education, birthday);
        this.direction = direction;
    }

    public void build() {

    }
}
