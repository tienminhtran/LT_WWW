package com.fit.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false,unique = true)
    private Integer id;

    @Pattern(regexp = "^Pro\\d{3}-(0[1-9]|1[0-2])$", message = "Code theo cấu trúc ProXXX-MM")
    private String code;

    @NotEmpty(message = "Name không được rỗng")
    @Pattern(regexp = "^[\\p{L}]{1,20}", message = "Name tối đa 20 ký tự chữ hoa hoặc chữ thường")
    private String name;

    @NotEmpty(message = "Description không được rỗng")
    private String description;

    @Column(name = "register_date")
    @CreationTimestamp
    @Past(message = "Ngày đăng ký phải trước ngày hiện tại")
    private Date registedDate;

    @Positive(message = "Price phải là số thực lớn hơn 0")
    @NotNull(message = "Price không được rỗng")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Category category;
}
