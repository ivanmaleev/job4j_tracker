package ru.job4j.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class AutoSalon {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();

            CarModel carModel1 = new CarModel("A1");
            CarModel carModel2 = new CarModel("A3");
            CarModel carModel3 = new CarModel("A4");
            CarModel carModel4 = new CarModel("A5");
            CarModel carModel5 = new CarModel("A7");

            CarBrand brand = new CarBrand();
            brand.setName("Audi");
            List<CarModel> models = List.of(carModel1, carModel2, carModel3, carModel4, carModel5);
            brand.setModels(models);

            session.save(carModel1);
            session.save(carModel2);
            session.save(carModel3);
            session.save(carModel4);
            session.save(carModel5);

            session.beginTransaction();
            session.save(brand);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
