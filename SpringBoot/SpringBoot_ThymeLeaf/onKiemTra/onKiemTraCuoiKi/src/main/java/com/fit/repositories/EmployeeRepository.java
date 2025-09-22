package com.fit.repositories;

import com.fit.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:keyword% " +
            "OR e.email LIKE %:keyword% " +
            "OR e.phone LIKE %:keyword% " +
            "OR e.address LIKE %:keyword% " +
            "OR CAST(e.salary AS string) LIKE %:keyword% "+
            "OR CAST(e.rating AS string) LIKE %:keyword% ")
    List<Employee> search(@Param("keyword") String keyword);


    @Query("SELECT e FROM Employee e WHERE e.birthday = :date")
    List<Employee> searchByDate(@Param("date") Date date);

}
