package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.Role;

public class RoleRepository {
    private EntityManager em;

    private EntityTransaction et;

    private EntityManagerFactory emf;


    public RoleRepository() {
        emf = Persistence.createEntityManagerFactory("JPA_MariaDB");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }



    public Role getRoleByIdAccount(String accountId) {
        try {
            return em.createNamedQuery("Role.findRoleByIdAccount", Role.class)
                    .setParameter("account_id", accountId)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
