package vn.edu.iuh.fit.week1.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.week1.dao.loginDao;
import vn.edu.iuh.fit.week1.entity.entityLogin;

public class loginImpl implements loginDao {
    private EntityManager em;
    private EntityTransaction et;
    private EntityManagerFactory emf;

    public loginImpl() {
        emf = Persistence.createEntityManagerFactory("SQL");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    @Override
    public boolean checkLogin(String username, String password) {
        String query = "Select a from entityLogin a where a.username = :username and a.password = :password";
        return !em.createQuery(query)
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList().isEmpty();

    }

    @Override
    public boolean insertLogin(entityLogin login) {
        try {
            et.begin();
            em.persist(login);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public void close() {
        em.close();
        emf.close();
    }
}
