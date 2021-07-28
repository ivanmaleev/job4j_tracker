package ru.job4j.pojo;

import java.lang.reflect.Array;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 150);
        Book greenBook = new Book("Green book", 72);
        Book blackBook = new Book("Black book", 60);
        Book otherBook = new Book("Other book", 40);

        Book[] setOfBooks = new Book[4];
        setOfBooks[0] = cleanCode;
        setOfBooks[1] = greenBook;
        setOfBooks[2] = blackBook;
        setOfBooks[3] = otherBook;

        for (int i = 0; i < setOfBooks.length; i++) {
            System.out.println("Name " + setOfBooks[i].getName()
                    + ", number of pages " + setOfBooks[i].getNumberOfPages());
        }

        System.out.println("---------------------");

        Book tempBook = new Book(setOfBooks[3].getName(), setOfBooks[3].getNumberOfPages());
        setOfBooks[3] = setOfBooks[0];
        setOfBooks[0] = tempBook;

        for (int i = 0; i < setOfBooks.length; i++) {
            System.out.println("Name " + setOfBooks[i].getName()
                    + ", number of pages " + setOfBooks[i].getNumberOfPages());
        }

        System.out.println("---------------------");

        for (int i = 0; i < setOfBooks.length; i++) {
            if ("Clean code".equals(setOfBooks[i].getName())) {
                System.out.println("Name " + setOfBooks[i].getName()
                        + ", number of pages " + setOfBooks[i].getNumberOfPages());
            }
        }
    }
}
