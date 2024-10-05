package test.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class main {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("SQL");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

            tx.begin();


            tx.commit();

    }
}
