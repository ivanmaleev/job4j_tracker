package ru.job4j.oop;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("To fly");
    }

    @Override
    public void refuel() {
        System.out.println("Fuel");
    }
}