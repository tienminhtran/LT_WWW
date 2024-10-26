/**
 * @ (#) XeRepositoriesImpl.java      10/24/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.Xe;
import vn.edu.iuh.fit.repositories.XeRepositories;

import java.util.List;

public class XeRepositoriesImpl implements XeRepositories {
    private EntityManager entityManager;
    private EntityTransaction et;

    public XeRepositoriesImpl() {
        entityManager = Persistence.createEntityManagerFactory("JPA_MariaDB").createEntityManager();
        et = entityManager.getTransaction();
    }


    @Override
    public List<Xe> findAll() {
        String query="SELECT x FROM Xe x";
        return entityManager.createQuery(query, Xe.class).getResultList();
    }

    @Override
    public List<Xe> findByTenXe(String tenXe) {
        String query="SELECT x FROM Xe x WHERE x.tenXe LIKE :tenXe";
        return entityManager.createQuery(query, Xe.class).setParameter("tenXe", "%"+tenXe+"%").getResultList();
    }

    @Override
    public Xe findById(long id) {
        return entityManager.find(Xe.class, id);
    }

    @Override
    public boolean save(Xe xe) {
        try {
            et.begin();
            entityManager.persist(xe);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Xe xe) {
        try {
            et.begin();
            entityManager.merge(xe);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        String query = "DELETE FROM Xe x WHERE x.id = :id";
        try {
            et.begin();
            entityManager.createQuery(query).setParameter("id", id).executeUpdate();
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
