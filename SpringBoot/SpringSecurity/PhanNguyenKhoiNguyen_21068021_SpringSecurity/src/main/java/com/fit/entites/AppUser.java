package com.fit.entites;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "APP_USER",
        uniqueConstraints = {
                @UniqueConstraint(name = "APP_USER_UK", columnNames = "USER_NAME")  //Ko trung ten dang nhap (cot USER_NAME)
})
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false, unique = true)
    private Long userId;

    @Column(name = "USER_NAME", length = 36, nullable = false)
    private String userName;

    @Column(name = "ENCRYTED_PASSWORD", length = 128, nullable = false)
    private String encrytedPassword;

    @Column(name = "ENABLED",nullable = false)
    private boolean enabled;
}
