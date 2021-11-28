package ru.job4j.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "carmodel")
public class CarModel {

    private int id;
    private String name;
    private CarBrand carBrand;

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

    @ManyToOne
    @JoinColumn(name = "carbrand_id")
    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    @Override
    public String toString() {
        return "CarModel{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}
