/**
 * @ (#) Order.java      9/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week2_phantiensinh.models;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/18/2024
 */

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long orderId;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @JsonbTransient
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    public Order(long orderId, LocalDateTime orderDate, Employee employee) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", employee=" + employee +
                '}';
    }

}
