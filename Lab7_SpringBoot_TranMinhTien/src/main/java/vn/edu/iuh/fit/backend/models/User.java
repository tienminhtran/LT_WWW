package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    @Column(name = "firstName", length = 50)
//    private String firstName;
//
//    @Column(name = "middleName", length = 50)
//    private String middleName;
//
//    @Column(name = "lastName", length = 50)
//    private String lastName;
//
//    @Column(name = "mobile", length = 15)
//    private String mobile;
//
//    @Column(name = "email", length = 50)
//    private String email;
//
//    @Column(name = "passwordHash", nullable = false, length = 32)
//    private String passwordHash;
//
//    @Column(name = "registeredAt", nullable = false)
//    private Instant registeredAt;
//
//    @Column(name = "lastLogin")
//    private Instant lastLogin;
//
//    @Lob
//    @Column(name = "intro")
//    private String intro;
//
//    @Lob
//    @Column(name = "profile")
//    private String profile;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String middleName;
    private String intro;
    private String lastLogin;
    private String mobile;

    @Column(nullable = false)
    private String passwordHash;

    private String profile;
    private String registeredAt;
//    public User(String firstName, String middleName, String lastName, String mobile, String email, String passwordHash, Instant registeredAt, String profile, Instant lastLogin, String intro) {
//        this.firstName = firstName;
//        this.middleName = middleName;
//        this.lastName = lastName;
//        this.mobile = mobile;
//        this.email = email;
//        this.passwordHash = passwordHash;
//        this.registeredAt = registeredAt;
//        this.profile = profile;
//        this.lastLogin = lastLogin;
//        this.intro = intro;
//    }
}