/**
 * @ (#) EmployeeRepoImpl.java      9/19/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week2_phantiensinh.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.week2_phantiensinh.models.Employee;
import vn.edu.iuh.fit.week2_phantiensinh.repositories.EmployRepository;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/19/2024
 */
public class EmployeeRepoImpl implements EmployRepository {
    private EntityManager em;
    private EntityTransaction et;

    public EmployeeRepoImpl() {
         em = Persistence.createEntityManagerFactory("JPA_MariaDB").createEntityManager();
         et = em.getTransaction();
    }

    @Override
    public boolean insertEmploy(Employee employee) {
        try {
            et.begin();
            em.persist(employee);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateEmploy(Employee employee) {
        try {
            et.begin();
            em.merge(employee);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteEmploy(long id) {


        return false;
    }

    @Override
    public boolean exists(long id) {
        return em.createNamedQuery("Employee.existsById", Boolean.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Employee> findAll() {
        try {
            return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Employee findById(long l) {
        return em.find(Employee.class, l);
    }
}
