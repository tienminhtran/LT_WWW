package vn.edu.iuh.fit.entities;


import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "account")
@NamedQueries({
        @NamedQuery(
                name = "Account.findAccountByIdPassword",
                query = "select a from Account a where a.account_id = :account_id and a.password = :password"
        ),
        @NamedQuery(
                name = "Account.findAccountsByRole",
                query = "select a from Account a join GrantAccess ga on a.account_id = ga.account.account_id where ga.role.role_id = :role_id"
        ),
        @NamedQuery(name = "Account.findAllAccount", query = "select a from Account a"),
})
public class Account {

    @Id
    @Column(columnDefinition = "varchar(50)")
    private String account_id;
    @Column(columnDefinition = "varchar(50)")
    private String full_name;
    @Column(columnDefinition = "varchar(50)")
    private String password;
    @Column(columnDefinition = "varchar(50)")
    private String email;
    @Column(columnDefinition = "varchar(50)")
    private String phone;
    private int status;

}
