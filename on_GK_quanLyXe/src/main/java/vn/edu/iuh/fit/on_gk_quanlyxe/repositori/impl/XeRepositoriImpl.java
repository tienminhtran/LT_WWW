package vn.edu.iuh.fit.on_gk_quanlyxe.repositori.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.on_gk_quanlyxe.entity.Xe;
import vn.edu.iuh.fit.on_gk_quanlyxe.repositori.XeRepositori;

import java.util.List;

public class XeRepositoriImpl implements XeRepositori {

    private EntityManager entityManager;
    private EntityTransaction et;

    @Override
    public List<Xe> getAlXe() {
        String query="SELECT x FROM Xe x";
        return entityManager.createQuery(query, Xe.class).getResultList();
    }

    @Override
    public List<Xe> fineTenXe(String tenXe) {
        String query="SELECT x FROM Xe x WHERE x.tenXe LIKE :tenXe";
        return entityManager.createQuery(query, Xe.class).setParameter("tenXe", "%"+tenXe+"%").getResultList();
    }
}