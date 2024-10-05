/**
* @ (#) ProductPrice.java      9/18/2024
*
* Copyright (c) 2024 IUH. All rights reserved
*/

package vn.edu.iuh.fit.week2_phantiensinh.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/18/2024
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_price")
public class ProductPrice {
    @Id
    @Column(nullable = false, name = "price_date_time")
    private LocalDateTime priceDateTime;

    @Column(nullable = false)
    private double price;

    private String note;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
