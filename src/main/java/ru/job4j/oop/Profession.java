package ru.job4j.oop;

public class Profession {
    private String name;
    private String surName;
    private String education;
    private String birthday;

    public Profession(String name, String surName, String education, String birthday) {
        this.name = name;
        this.surName = surName;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getEducation() {
        return education;
    }

    public String getBirthday() {
        return birthday;
    }
}
