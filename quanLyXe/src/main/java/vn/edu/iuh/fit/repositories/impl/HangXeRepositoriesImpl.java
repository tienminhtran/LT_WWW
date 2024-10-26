/**
 * @ (#) HangXeRepositoriesImpl.java      10/24/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.HangXe;
import vn.edu.iuh.fit.repositories.HangXeRepositories;

import java.util.List;


public class HangXeRepositoriesImpl implements HangXeRepositories
{
    private EntityManager entityManager;
    private EntityTransaction et;

    public HangXeRepositoriesImpl() {
        entityManager = Persistence.createEntityManagerFactory("JPA_MariaDB").createEntityManager();
        et = entityManager.getTransaction();
    }
    @Override
    public HangXe findById(long id) {
        return entityManager.find(HangXe.class, id);
    }

    @Override
    public HangXe findByTenHangXe(String hangXe) {
        String query="SELECT h FROM HangXe h WHERE h.tenHangXe LIKE :hangXe";
        return entityManager.createQuery(query, HangXe.class).setParameter("hangXe", "%"+hangXe+"%").getResultList().get(0);
    }

    @Override
    public List<HangXe> findAll() {
        return entityManager.createQuery("SELECT h FROM HangXe h", HangXe.class).getResultList();
    }
}
