package ru.job4j.hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carbrand")
public class CarBrand {

    private int id;
    private String name;
    private List<CarModel> models = new ArrayList<>();

    public CarBrand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CarBrand() {
    }

    public CarBrand(String name) {
        this.name = name;
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    public List<CarModel> getModels() {
        return models;
    }

    public void setModels(List<CarModel> models) {
        this.models = models;
    }

    public void addModel(CarModel model) {
        this.models.add(model);
    }
}
