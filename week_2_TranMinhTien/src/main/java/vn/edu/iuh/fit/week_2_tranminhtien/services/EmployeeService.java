/**
 * @ (#) EmployeeService.java      9/19/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week2_phantiensinh.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.week2_phantiensinh.enums.EmployeeStatus;
import vn.edu.iuh.fit.week2_phantiensinh.models.Employee;
import vn.edu.iuh.fit.week2_phantiensinh.repositories.EmployRepository;
import vn.edu.iuh.fit.week2_phantiensinh.repositories.impl.EmployeeRepoImpl;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/19/2024
 */
public class EmployeeService {
    private final EmployRepository employRepository;

    public EmployeeService() {
        employRepository = new EmployeeRepoImpl();
    }

    public boolean insertEmploy(Employee employee) {
        return employRepository.insertEmploy(employee);
    }

    public boolean updateEmploy(Employee employee) {
        return employRepository.updateEmploy(employee);
    }

    public boolean deleteEmploy(long id) {
        Employee employee = employRepository.findById(id);
        if (employee != null) {
            employee.setStatus(EmployeeStatus.TERMINATED);
            return employRepository.updateEmploy(employee);
        }
        return false;
    }

    public boolean exists(long id) {
        return employRepository.exists(id);
    }

    public List<Employee> findAll() {
        return employRepository.findAll();
    }

    public Employee findById(long l) {
        return employRepository.findById(l);
    }
}
