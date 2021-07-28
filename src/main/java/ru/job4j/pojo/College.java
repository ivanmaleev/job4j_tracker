package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Ivanov Ivan Ivanych");
        student.setGroup("12-03");
        student.setDate(new Date());
        System.out.println("ФИО " + student.getFio() + ", группа "
                + student.getGroup() + ", дата поступления "
                + student.getDate());
    }
}
