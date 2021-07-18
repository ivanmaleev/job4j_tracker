package ru.job4j.oop;

public class Dentist extends Doctor {
    private int grade;

    public Dentist(String name, String surName, String education, String birthday, int grade) {
        super(name, surName, education, birthday);
        this.grade = grade;
    }

    public void cureATooth() {

    }
}
