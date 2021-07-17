package ru.job4j.oop;

public class Battery {
    private int load;

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery battery1 = new Battery();
        Battery battery2 = new Battery();
        battery1.load = 10;
        battery2.load = 5;
        battery1.exchange(battery2);
    }
}
