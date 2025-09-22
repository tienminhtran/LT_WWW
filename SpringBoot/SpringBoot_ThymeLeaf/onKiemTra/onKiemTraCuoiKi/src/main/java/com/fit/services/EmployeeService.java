package com.fit.services;

import com.fit.entities.Employee;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EmployeeService {
    public Employee getEmployeeById(int id);
    public Employee addEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public Employee updateEmployee(Employee employee);
    public boolean deleteEmployee(int id);
    public List<Employee> searchByKeyWord(String keyWord);
    public List<Employee> searchByKeyWordDate(Date keyWord);
}
