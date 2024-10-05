package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "log")
@NamedQueries({
        @NamedQuery(name = "Log.updateAccountIdAndLoginTimeAndLogoutTimeAndNotesBy", query = "update Log l set l.accountId = :accountId, l.loginTime = :loginTime, l.logoutTime = :logoutTime, l.notes = :notes"),
        @NamedQuery(name = "Log.deleteByAccountId", query = "delete from Log l where l.accountId = :accountId")
})
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "account_id", nullable = false, length = 50)
    private String accountId;

    @Column(name = "login_time", nullable = false)
    private Instant loginTime;

    @Column(name = "logout_time", nullable = false)
    private Instant logoutTime;

    @Column(name = "notes", nullable = false, length = 250)
    private String notes;

}