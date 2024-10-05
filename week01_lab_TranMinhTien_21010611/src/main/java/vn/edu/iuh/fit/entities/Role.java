package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
@NamedQueries({
        @NamedQuery(
                name = "Role.findRoleByIdAccount",
                query = "select r from Role r join GrantAccess ga on r.role_id = ga.role.role_id where ga.account.account_id = :account_id"
        )
})
public class Role {
    @Id
    @Column(columnDefinition = "varchar(50)")
    private String role_id;
    @Column(columnDefinition = "varchar(50)")
    private String role_name;
    @Column(columnDefinition = "varchar(50)")
    private String description;
    private int status;
}
