/**
 * @ (#) Employee.java      9/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week2_phantiensinh.models;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.week2_phantiensinh.converters.EmployeeStatusConverter;
import vn.edu.iuh.fit.week2_phantiensinh.enums.EmployeeStatus;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/18/2024
 */
@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
        @NamedQuery(name = "Employee.existsById", query = "select (count(e) > 0) from Employee e where e.id = :id")
})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long id;

    @Column(nullable = false)
    private LocalDateTime dob;

    @Column(length = 150,unique = true)
    private String email;

    @Column(length = 250, nullable = false)
    private String address;

    @Column(nullable = false)
    @Convert(converter = EmployeeStatusConverter.class)
    private EmployeeStatus status;

    @Column(length = 15, nullable = false)
    private String phone;

    @Column(name = "full_name", length = 150, nullable = false)
    private String fullName;

    @JsonbTransient
    @OneToMany(mappedBy = "employee")
    private List<Order> orderList;

    public Employee(long id, LocalDateTime dob, String email, String address, EmployeeStatus status, String phone, String fullName) {
        this.id = id;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.status = status;
        this.phone = phone;
        this.fullName = fullName;
    }

    public Employee(LocalDateTime dob, String email, String address, EmployeeStatus status, String phone, String fullName) {
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.status = status;
        this.phone = phone;
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + id +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }
}
