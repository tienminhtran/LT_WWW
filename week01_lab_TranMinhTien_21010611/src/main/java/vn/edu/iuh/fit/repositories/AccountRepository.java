package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.Account;

import java.util.List;

public class AccountRepository {

    private EntityManager em;

    private EntityTransaction et;

    private EntityManagerFactory emf;

    public AccountRepository() {
        emf = Persistence.createEntityManagerFactory("JPA_MariaDB");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    public boolean insertAccount(Account account) {
        try {
            et.begin();
            em.persist(account);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAccount(Account account) {
        try {
            et.begin();
            em.merge(account);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public Account findAccountByIdPassword(String account_id, String password) {
        try{
            return (Account) em.createNamedQuery("Account.findAccountByIdPassword")
                    .setParameter("account_id", account_id)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Account findOneAccountById(String account_id) {
       return em.find(Account.class, account_id);
    }

    //findAllAccount
    public List<Account> findAllAccount(){
        return em.createNamedQuery("Account.findAllAccount", Account.class).getResultList();
    }
    //xoa
    public boolean deleteAccount(String account_id) {
        String sql = "Update Account a set a.status = -1 where a.account_id = :account_id";
        try {
            et.begin();
            em.createQuery(sql)
                    .setParameter("account_id", account_id)
                    .executeUpdate();
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }







}
