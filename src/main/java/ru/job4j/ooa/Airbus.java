package ru.job4j.ooa;

public final class Airbus extends Aircraft {
    private static final int COUNT_ENGINE = 2;
    private static final int COUNT_ENGINE_A380 = 4;

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printCountEngine() {
        if ("A380".equals(this.getName())) {
            System.out.println("Количество двигателей равно: " + COUNT_ENGINE_A380);
            return;
        }
        System.out.println("Количество двигателей равно: " + COUNT_ENGINE);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}