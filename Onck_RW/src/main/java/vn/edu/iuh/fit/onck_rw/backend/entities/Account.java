package vn.edu.iuh.fit.onck_rw.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.onck_rw.backend.enums.AccoutStatus;

import java.io.Serializable;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
public class Account implements Serializable {

    @Id
    @Column(name="acc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="acc_balance")
    private double balance;

    @ManyToOne
    @JoinColumn(name="cust_id")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    @Column(name="acc_status")
    private AccoutStatus status;
}
