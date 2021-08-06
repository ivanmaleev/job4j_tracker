package ru.job4j.stream;

public class Car {
    private String brand;
    private String model;
    private int horsePower;
    private int maxSpeed;
    private int numberOfCylinders;

    static class Builder {
        private String brand;
        private String model;
        private int horsePower;
        private int maxSpeed;
        private int numberOfCylinders;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildHorsePower(int horsePower) {
            this.horsePower = horsePower;
            return this;
        }

        Builder buildMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        Builder buildNumberOfCylinders(int numberOfCylinders) {
            this.numberOfCylinders = numberOfCylinders;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.maxSpeed = maxSpeed;
            car.horsePower = horsePower;
            car.numberOfCylinders = numberOfCylinders;
            return car;
        }
    }

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", horsePower=" + horsePower
                + ", maxSpeed=" + maxSpeed
                + ", numberOfCylinders=" + numberOfCylinders
                + '}';
    }

    public static void main(String[] args) {
        Car car = new Builder().buildBrand("Audi")
                .buildModel("Q8")
                .buildHorsePower(500)
                .buildMaxSpeed(300)
                .buildNumberOfCylinders(8)
                .build();
        System.out.println(car);
    }
}
