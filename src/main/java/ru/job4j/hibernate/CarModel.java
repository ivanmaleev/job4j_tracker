package ru.job4j.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "carmodel")
public class CarModel {

    private int id;
    private String name;

    public CarModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CarModel(String name) {
        this.name = name;
    }

    public CarModel() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
