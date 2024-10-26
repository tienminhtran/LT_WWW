package vn.edu.iuh.fit.on_gk.repositori.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.on_gk.entity.HangXe;
import vn.edu.iuh.fit.on_gk.repositori.HangXeRepositori;

import java.util.List;

public class HangXeRepositoriImpl implements HangXeRepositori {


    private EntityManager entityManager;
    private EntityTransaction et;

    public HangXeRepositoriImpl() {
        entityManager = Persistence.createEntityManagerFactory("JPA_MariaDB").createEntityManager();
        et = entityManager.getTransaction();

    }

    @Override
    public List<HangXe> getDsHangXe() {
        String sql = "SELECT hx FROM HangXe hx";
        return this.entityManager.createQuery(sql, HangXe.class).getResultList();
    }

    @Override
    public HangXe findByID(int id) {
        String sql = "SELECT hx FROM HangXe hx WHERE hx.id = :id";
        return this.entityManager.createQuery(sql, HangXe.class).setParameter("id", id).getSingleResult();
    }
}
