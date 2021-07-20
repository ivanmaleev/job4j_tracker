package ru.job4j.poly;

public interface Transport {
    void ride();

    void passengers(int numberOfPassengers);

    int refuel(int fuelQuantity);
}
