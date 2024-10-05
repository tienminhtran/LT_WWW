/**
 * @ (#) ProductImage.java      9/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week2_phantiensinh.models;

import jakarta.persistence.*;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/18/2024
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private long imageId;
    
    @Column(length = 250)
    private String alternative;
    
    @Column(length = 250, nullable = false)
    private String path;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
