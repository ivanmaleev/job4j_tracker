package ru.job4j.ooa;

public class Airport {
    public static void main(String[] args) {
        final Airbus airbus = new Airbus("A320");
        System.out.println(airbus);
        airbus.printModel();
        airbus.printCountEngine();

        Airbus airbus2 = new Airbus("A380");
        System.out.println(airbus);
        airbus2.printModel();
        airbus2.printCountEngine();

        airbus.setName("A380");
        System.out.println(airbus);
        airbus.printModel();
        airbus.printCountEngine();
    }
}