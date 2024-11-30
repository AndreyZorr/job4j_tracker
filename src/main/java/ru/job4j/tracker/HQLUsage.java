package ru.job4j.tracker;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HQLUsage {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (SessionFactory sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sf.openSession();
            try {
                session.beginTransaction();
                session.createQuery(
                                "UPDATE Item SET name = :fName WHERE id = :fId")
                        .setParameter("fName", "new name")
                        .setParameter("fId", sf)
                        .executeUpdate();
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
            }
            session.close();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}