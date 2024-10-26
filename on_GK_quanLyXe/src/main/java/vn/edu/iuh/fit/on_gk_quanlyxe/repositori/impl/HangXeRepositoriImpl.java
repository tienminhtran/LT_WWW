package vn.edu.iuh.fit.on_gk_quanlyxe.repositori.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.on_gk_quanlyxe.entity.HangXe;
import vn.edu.iuh.fit.on_gk_quanlyxe.repositori.HangXeRepositori;

import java.util.List;

public class HangXeRepositoriImpl implements HangXeRepositori {


    private EntityManager entityManager;
    private EntityTransaction et;

    public HangXeRepositoriImpl() {
        entityManager = Persistence.createEntityManagerFactory("JPA_MariaDB").createEntityManager();
        et = entityManager.getTransaction();

    }

    @Override
    public List<HangXe> findTenHangXe(String tenHangXe) {
        return List.of();
    }

    @Override
    public HangXe findHangXeById(String id) {
        return entityManager.find(HangXe.class, id);
    }
}
