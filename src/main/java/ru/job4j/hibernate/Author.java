package ru.job4j.hibernate;

import java.util.List;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "author")
public class Author {
    private int id;
    private String name;
    private List<Book> books = new ArrayList<>();

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author(String name) {
        this.name = name;
    }

    public Author() {
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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
