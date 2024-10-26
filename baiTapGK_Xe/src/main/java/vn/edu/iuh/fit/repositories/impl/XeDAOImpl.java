/*
 * @ {#} XeDAOImpl.java   1.0     24/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.Xe;
import vn.edu.iuh.fit.repositories.XeDAO;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   24/10/2024
 * @version:    1.0
 */
public class XeDAOImpl implements XeDAO {
    private EntityManager em;

    public XeDAOImpl() {
        this.em = Persistence.createEntityManagerFactory("mariadb").createEntityManager();
    }
    @Override
    public List<Xe> getDsXe() {
        String sql = "SELECT x FROM Xe x";
        return this.em.createQuery(sql, Xe.class).getResultList();
    }

    @Override
    public Xe findByID(int id) {
        String sql = "SELECT x FROM Xe x WHERE x.id = :id";
        return this.em.createQuery(sql, Xe.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public Xe findByTenXe(String name) {
        String sql = "SELECT x FROM Xe x WHERE x.tenxe = :name";
        return this.em.createQuery(sql, Xe.class).setParameter("name", name).getSingleResult();
    }

    @Override
    public Xe findByGiaXe(double gia) {
        String sql = "SELECT x FROM Xe x WHERE x.giaxe = :gia";
        return this.em.createQuery(sql, Xe.class).setParameter("gia", gia).getSingleResult();
    }

    @Override
    public Xe addXe(Xe xe) {
        try {
            this.em.getTransaction().begin();
            this.em.persist(xe);
            this.em.getTransaction().commit();
            return xe;
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public Xe updateXe(Xe xe) {
        try {
            this.em.getTransaction().begin();
            this.em.merge(xe);
            this.em.getTransaction().commit();
            return xe;
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public Xe deleteXe(Xe xe) {
        try {
            this.em.getTransaction().begin();
            this.em.remove(xe);
            this.em.getTransaction().commit();
            return xe;
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            return null;
        }
    }
}
