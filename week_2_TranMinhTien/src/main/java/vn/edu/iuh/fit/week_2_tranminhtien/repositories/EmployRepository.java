/**
 * @ (#) EmployRepository.java      9/19/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week2_phantiensinh.repositories;

import vn.edu.iuh.fit.week2_phantiensinh.models.Employee;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/19/2024
 */
public interface EmployRepository {
    public boolean insertEmploy(Employee employee);
    public boolean updateEmploy(Employee employee);
    public boolean deleteEmploy(long id);
    public boolean exists(long id);
    public List<Employee> findAll();
    public Employee findById(long l);
}
