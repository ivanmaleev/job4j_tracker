package ru.job4j.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Libruary {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();

            Book book1 = new Book("black book");
            Book book2 = new Book("green book");
            Book book3 = new Book("The third book");
            Book book4 = new Book("Other book");

            Author author1 = new Author("Some guy");
            Author author2 = new Author("Other guy");

            author1.getBooks().add(book1);
            author1.getBooks().add(book2);
            author1.getBooks().add(book3);

            author2.getBooks().add(book3);
            author2.getBooks().add(book4);

            session.beginTransaction();
            session.persist(author1);
            session.persist(author2);
            session.remove(author1);
            session.remove(author2);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
