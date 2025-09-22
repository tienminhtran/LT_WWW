package com.fit.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;

    @NotBlank(message = "Title không được trống")
    @Size(min = 1, max = 50, message = "Title không được quá 50 ký tự")
    private String title;

    @NotBlank(message = "Author không được trống")
    private String author;

    @NotBlank(message = "Description không được trống")
    @Size(min = 10, message = "Description có ít nhất 10 ký tự")
    private String description;

    @Past(message = "Publish Date phải là ngày trong quá khứ")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price phải lớn hơn 0")
    @Column(columnDefinition = "DOUBLE", nullable = false)
    private Double price;

    @NotNull(message = "Category không được trống")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CartID")
    private Category category;
}