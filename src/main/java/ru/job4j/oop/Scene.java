package ru.job4j.oop;

public class Scene {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = plane;
        vehicles[1] = bus;
        vehicles[2] = train;
        for (Vehicle veh : vehicles) {
            veh.move();
        }
    }
}
