package ru.job4j.hibernate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vacanciesbd")
public class VacanciesBD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Vacancie> vacancies;

    public VacanciesBD() {
    }

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

    public List<Vacancie> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancie> vacancies) {
        this.vacancies = vacancies;
    }
}
