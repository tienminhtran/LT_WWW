package vn.edu.iuh.fit.onck_rw.backend.service;

import vn.edu.iuh.fit.onck_rw.backend.entities.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomers();
    public Customer getCustomerById(long id);
    public List<Customer> getCustomerByYear2000();
    public Customer saveCustomer(Customer customer);
    public void deleteCustomer(long id);
    public Customer updateCustomer(Customer customer);

}
