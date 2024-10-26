package vn.edu.iuh.fit.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "skill_name", length = 100)
    private String skillName;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "field", length = 100)
    private String field;

}