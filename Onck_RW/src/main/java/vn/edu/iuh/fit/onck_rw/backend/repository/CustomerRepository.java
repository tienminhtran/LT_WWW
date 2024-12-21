package vn.edu.iuh.fit.onck_rw.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.onck_rw.backend.entities.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE  YEAR(c.dob) = 2000")
    public List<Customer> findCustomerByYear2000();

}
