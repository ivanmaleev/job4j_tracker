package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
        System.out.println("Riding...");
    }

    @Override
    public void passengers(int numberOfPassengers) {
        System.out.println("Number of passengers: " + numberOfPassengers);
    }

    @Override
    public int refuel(int fuelQuantity) {
        int price = 30;
        return fuelQuantity * price;
    }
}
