package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("To ride on rails");
    }

    @Override
    public void refuel() {
        System.out.println("Coal");
    }
}
