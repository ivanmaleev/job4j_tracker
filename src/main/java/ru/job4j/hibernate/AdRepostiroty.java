package ru.job4j.hibernate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "adrepostiroty")
public class AdRepostiroty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date created;
}
