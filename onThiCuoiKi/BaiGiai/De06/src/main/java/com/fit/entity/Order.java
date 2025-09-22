package com.fit.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.*;
import org.hibernate.annotations.Formula;




@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Integer ID;

    @Min(value = 5, message = "ProID lớn hơn hoặc bằng 5")
    @Max(value = 20, message = "ProID phải nhỏ hơn hoặc bằng 20")
    @NotNull(message = "ProID không được trống")
    private Integer ProID;

    @Column(name = "ProName", nullable = false)
    @NotBlank(message = "Tên sản phẩm không được để trống")
    private String ProName;

    @Positive(message = "Quantity phải là số dương")
    @NotNull(message = "Quantity không được trống")
    private Integer Quantity;

    @DecimalMin(value = "5.2",  inclusive = true, message = "Price phải lớn hơn hoặc bằng 5.2")
    @NotNull(message = "Price không được trống")
    private Double Price;

    @Formula("Quantity * Price")
    private Double TotalPrice;
}
