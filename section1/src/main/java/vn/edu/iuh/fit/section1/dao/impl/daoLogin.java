package vn.edu.iuh.fit.section1.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.section1.entity.entityLogin;

public class daoLogin implements DaoImpl{

    private EntityManager em;

    private EntityTransaction et;

    private EntityManagerFactory emf;

    public daoLogin() {
        emf = Persistence.createEntityManagerFactory("JPA_MSSQL");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    @Override
    public entityLogin checkName(String username) {

        return em.find(entityLogin.class, username);
    }
}
