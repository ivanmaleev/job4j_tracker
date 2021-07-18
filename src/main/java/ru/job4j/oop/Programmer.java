package ru.job4j.oop;

public class Programmer extends Engineer {
    private String language;

    public Programmer(String name, String surName, String education, String birthday, String language) {
        super(name, surName, education, birthday);
        this.language = language;
    }

    public void toCode() {

    }
}
