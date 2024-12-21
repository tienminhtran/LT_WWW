package vn.edu.iuh.fit.onck_rw.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.onck_rw.backend.entities.Customer;
import vn.edu.iuh.fit.onck_rw.backend.repository.CustomerRepository;
import vn.edu.iuh.fit.onck_rw.backend.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> getCustomerByYear2000() {
       return customerRepository.findCustomerByYear2000();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);

    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer existingCustomer = customerRepository.findById(customer.getId()).get();
        existingCustomer.setName(customer.getName());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setDob(customer.getDob());
        existingCustomer.setEmail(customer.getEmail());
        return customerRepository.save(existingCustomer);
    }
}
