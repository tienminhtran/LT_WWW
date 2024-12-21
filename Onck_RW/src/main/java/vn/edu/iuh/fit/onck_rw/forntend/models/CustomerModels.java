package vn.edu.iuh.fit.onck_rw.forntend.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.onck_rw.backend.entities.Customer;

import java.util.List;

@Component
public class CustomerModels {


    @Autowired
    private RestTemplate restTemplate;
    public List<Customer> getAllCustomers(){
        return restTemplate.getForObject("http://localhost:8080/api/customers/list", List.class);
    }

    public Customer getCustomerById(Long id){
        return restTemplate.getForObject("http://localhost:8080/api/customers/chitiet/"+id, Customer.class);
    }
    public List<Customer>  findCustomerByYear2000(){
        return restTemplate.getForObject("http://localhost:8080/api/customers/year2000", List.class);
    }

    public Customer saveCustomer(Customer customer){
       HttpHeaders headers = new HttpHeaders();
       headers.set("Content-Type", "application/json");
       HttpEntity<Customer> request = new HttpEntity<>(customer, headers);
       ResponseEntity<Customer> res = restTemplate.exchange(
               "http://localhost:8080/api/customers",
               HttpMethod.POST,
               request,
               Customer.class
       );
         return res.getBody();
    }

    public void deleteCustomer(long id){
        restTemplate.delete("http://localhost:8080/api/customers/xoa/"+id);
    }
}
