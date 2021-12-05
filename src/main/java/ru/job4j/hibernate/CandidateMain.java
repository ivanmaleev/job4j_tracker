package ru.job4j.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class CandidateMain {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            /*

            Candidate middle = new Candidate("Mike", "Middle", 100000);
            Candidate junior = new Candidate("Joe", "junior", 50000);
            Candidate senjor = new Candidate("Alex", "senjor", 150000);

            session.save(middle);
            session.save(junior);
            session.save(senjor);

            List<Candidate> allCandidates = session.createQuery(
                    "from Candidate ")
                    .list();
            allCandidates.forEach(System.out::println);

            Candidate cand = (Candidate) session.createQuery(
                    "from Candidate where id =: id")
                    .setParameter("id", 1)
                    .uniqueResult();
            System.out.println(cand);
            */
            
            List<Candidate> candidates = session.createQuery(
                    "from Candidate where name =: name")
                    .setParameter("name", "Joe")
                    .list();
            candidates.forEach(System.out::println);

            /*
            Query query = session.createQuery(
                    "UPDATE Candidate c set c.name = : name where id = : id")
                    .setParameter("name", "AlexC")
                    .setParameter("id", 3);
            query.executeUpdate();

            query = session.createQuery(
                    "DELETE from Candidate where id = : id")
                    .setParameter("id", 3);
            query.executeUpdate();

            Candidate cand1c = new Candidate("Mila", "1c sen", 120000);
            VacanciesBD vacanciesBD = new VacanciesBD();
            vacanciesBD.setId(1);
            cand1c.setVacanciesBD(vacanciesBD);
            session.saveOrUpdate(cand1c);

            Query<Candidate> query = session.createQuery(
                    "select distinct c from Candidate c "
                            + "join fetch c.vacanciesBD vbd "
                            + "join fetch vbd.vacancies v "
                            + "where c.id = : id")
                    .setParameter("id", 4);
            List<Candidate> allCandidates = query.list();
            allCandidates.forEach(System.out::println);
             */

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
