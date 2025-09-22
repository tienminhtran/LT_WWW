package com.fit.services;

import com.fit.entities.Employee;
import com.fit.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployeeById(int id) {
//        return employeeRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if (!employeeRepository.existsById(employee.getId())) {
            throw new RuntimeException("Employee not found with id: " + employee.getId());
        }
        return employeeRepository.save(employee);
    }

    @Override
    public boolean deleteEmployee(int id) {
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return true;
        }else{
//            throw new RuntimeException("Employee not found: " + id);
            return false;
        }
    }

    @Override
    public List<Employee> searchByKeyWord(String keyWord) {
        return employeeRepository.search(keyWord);
    }

    @Override
    public List<Employee> searchByKeyWordDate(Date keyWord) {
        return employeeRepository.searchByDate(keyWord);
    }

}
