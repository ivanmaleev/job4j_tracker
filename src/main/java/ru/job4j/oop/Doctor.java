package ru.job4j.oop;

public class Doctor extends Profession {

    public Diagnosis heal() {
        return new Diagnosis();
    }
}
