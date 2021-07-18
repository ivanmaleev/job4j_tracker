package ru.job4j.oop;

public class Doctor extends Profession {

    public Doctor(String name, String surName, String education, String birthday) {
        super(name, surName, education, birthday);
    }

    public Diagnosis heal() {
        return new Diagnosis();
    }
}
