package vn.edu.iuh.fit.onck_rw.backend.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.onck_rw.backend.entities.Customer;
import vn.edu.iuh.fit.onck_rw.backend.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestAPI {
    @Autowired
    private CustomerService customerService;
    @RequestMapping("/list")
    public ResponseEntity <List<Customer>> getAllCustomers(){
        List<Customer> c = customerService.getAllCustomers();
        return ResponseEntity.ok(c);
    }
    @RequestMapping("/chitiet/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id){
        Customer c = customerService.getCustomerById(id);
        return ResponseEntity.ok(c);
    }
    @RequestMapping("/year2000")
    public ResponseEntity<List<Customer>> getCustomerByYear2000() {
        List<Customer> customers = customerService.getCustomerByYear2000();
        return ResponseEntity.ok(customers);
    }
    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        Customer c = customerService.saveCustomer(customer);
        return ResponseEntity.ok(c);
    }

    @DeleteMapping("/xoa/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/sua/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Customer c = customerService.updateCustomer(customer);
        return ResponseEntity.ok(c);
    }
}
