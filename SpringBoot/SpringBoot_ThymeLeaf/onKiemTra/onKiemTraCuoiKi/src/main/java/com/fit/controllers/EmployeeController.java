package com.fit.controllers;


import com.fit.entities.Employee;
import com.fit.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //show form add employee
    @GetMapping("/showFormAdd")
    public ModelAndView showFormAddEmployee() {
        return new ModelAndView("addEmployee_Form", "employee", new Employee());
    }

    //add employee
    @PostMapping("/addEmployee")
    public ModelAndView addEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("addEmployee_Form");
        }
        employeeService.addEmployee(employee);
        return new ModelAndView("redirect:/employee/home");
    }


    //show list employee
    @GetMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home", "listEmployee", employeeService.getAllEmployees());
    }

    //Delte employee
    @GetMapping("/delete")
    public ModelAndView deleteEmployee(@ModelAttribute("id") int employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ModelAndView("redirect:/employee/home");
    }


    //show form update
    @GetMapping("/showFormUpdate")
    public ModelAndView showFormUpdateEmployee(@ModelAttribute("id") int employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return new ModelAndView("updateEmployee_Form", "employee", employee);
    }

    @PostMapping("/update")
    public ModelAndView update(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
        System.out.println(employee);
        if (result.hasErrors()) {
            return new ModelAndView("updateEmployee_Form");
        }
        employeeService.updateEmployee(employee);
        return new ModelAndView("redirect:/employee/home");
    }

    @PostMapping("/search")
    public ModelAndView search(@RequestParam("keyword") String keyword) {

       List<Employee> employees;
//
//       employees = employeeService.searchByKeyWord(keyword);
//       return new ModelAndView("home", "listEmployee", employees);

        try {
            // Kiểm tra nếu input là ngày
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            Date date = sdf.parse(keyword);
            // Nếu đúng là ngày, tìm theo ngày
            employees =  employeeService.searchByKeyWordDate(date);
        } catch (Exception e) {
            employees =  employeeService.searchByKeyWord(keyword);
        }
        return new ModelAndView("home", "listEmployee", employees);
    }



}
