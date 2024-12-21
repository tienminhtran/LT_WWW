package vn.edu.iuh.fit.onck_rw.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.onck_rw.backend.entities.Account;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

    @Query("SELECT a FROM Account a WHERE a.balance >= ?1 AND a.balance <= ?2")
    public List<Account> findAccountByBalanceBetween(double min, double max);


}
