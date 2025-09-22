package com.fit.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.DataOutputStream;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @NotNull(message = "Id is required")
    private int id;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message ="Gender is required")
    private String gender;

    @Email
    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "Phone is required")
    @Pattern(regexp = "(09|01[2|6|8|9])+([0-9]{8})", message = "Phone is invalid")
    private String phone;

    @NotEmpty(message = "Address is required")
    @Size(min = 10, max = 20, message = "Address must be between 10 and 20 characters")
    private String address;

    @Past(message = "Birthday is invalid")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @CreationTimestamp  // auto set value when insert
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedDate;

    @Min(value = 1, message = "Salary must be greater than 1")
    @Column(name = "salary", nullable = false)
    private double salary;

    @Positive(message = "Rating must be positive")
    private float rating;

    @NotNull(message = "Status is required")
    private boolean status;

}
