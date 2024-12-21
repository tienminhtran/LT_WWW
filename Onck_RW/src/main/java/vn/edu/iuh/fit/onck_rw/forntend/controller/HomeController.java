package vn.edu.iuh.fit.onck_rw.forntend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.onck_rw.backend.entities.Customer;
import vn.edu.iuh.fit.onck_rw.backend.service.AccountService;
import vn.edu.iuh.fit.onck_rw.forntend.models.CustomerModels;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private CustomerModels customerModels;

    @Autowired
    private AccountService accountService;
    @GetMapping({"/",""})
    public String index() {
        return "index";
    }
    @GetMapping("/customers")
    public String getAllCostumers(Model model){
        List<Customer> list = customerModels.getAllCustomers();
        model.addAttribute("listCustomer", list);
        return "customers";
    }
    @GetMapping("/customers/chitiet/{id}")
    public String getCusDetail(Model model, @PathVariable long id){
        Customer c = customerModels.getCustomerById(id);
        model.addAttribute("customerchitiet", c);
        return "customer_detail";

    }
    @GetMapping("/customers/year2000")
    public  String getCustomerByYear2000(Model model){
        List<Customer> list = customerModels.findCustomerByYear2000();
        model.addAttribute("listCustomer", list);
        return "report2";
    }
    @GetMapping("/add_customer")
    public String savaCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "add_customer";
    }
    @PostMapping("/add_customer/save")
    public String saveCustomer(RedirectAttributes redirectAttributes, Customer customer) {
        customerModels.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("message", "Thêm khách hàng thành công!");
        return "redirect:/customers";
    }

    @GetMapping("/customers/xoa/{id}")
    public String deleteCustomer( Model model, @PathVariable long id){
        customerModels.deleteCustomer(id);
        return "redirect:/customers";
    }

    @GetMapping("/customers/sua/{id}")
    public String updateCustomer(Model model, @PathVariable long id){
        Customer c = customerModels.getCustomerById(id);
        model.addAttribute("customer", c);
        return "add_customer";
    }
    @GetMapping("/account/find")
    public String findAccountByBalance(Model model){
        return "report1";
    }

    @GetMapping("/account/findwith")
    public String findAccountByBalanceBetween(Model model, @RequestParam("min") double min, @RequestParam("max") double max){
        model.addAttribute("LISTAC", accountService.getAccountByBalanceBetween(min, max));
        return "report1";
    }

}
