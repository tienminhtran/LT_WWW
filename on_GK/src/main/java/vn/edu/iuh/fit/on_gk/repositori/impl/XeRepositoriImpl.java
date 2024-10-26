package vn.edu.iuh.fit.on_gk.repositori.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.on_gk.entity.Xe;
import vn.edu.iuh.fit.on_gk.repositori.XeRepositori;

import java.util.List;

public class XeRepositoriImpl implements XeRepositori {

    private EntityManager entityManager;
    private EntityTransaction et;

    public XeRepositoriImpl() {
        entityManager = Persistence.createEntityManagerFactory("JPA_MariaDB").createEntityManager();
        et = entityManager.getTransaction();

    }


    @Override
    public List<Xe> getDsXe() {
        String sql = "SELECT x FROM Xe x";
        return entityManager.createQuery(sql, Xe.class).getResultList();
    }

    @Override
    public Xe findByID(int id) {
        String sql = "SELECT x FROM Xe x WHERE x.id = :id";
        return entityManager.createQuery(sql, Xe.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public  List<Xe>  findByTenXe(String tenXe) {
        String sql = "SELECT x from Xe x where x.tenXe like :tenXe";
        return entityManager.createQuery(sql, Xe.class)
                .setParameter("tenXe", "%"+tenXe+"%")
                .getResultList();

    }

    @Override
    public Xe findByGiaXe(double gia) {
        String sql = "SELECT x FROM Xe x WHERE x.giaXe = :gia";
        return entityManager.createQuery(sql, Xe.class)
                .setParameter("gia", gia)
                .getSingleResult();
    }

    @Override
    public boolean addXe(Xe xe) {
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
    public boolean updateXe(Xe xe){
        try{
            et.begin();
            entityManager.merge(xe);
            et.commit();
            return true;
        }
        catch (Exception e){
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteXe(Xe xe) {
        return true;
    }


}