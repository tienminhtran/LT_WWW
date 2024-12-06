package vn.edu.iuh.fit.backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.backend.enums.SkillType;

import java.io.Serializable;

@Getter
@Setter
@Entity
@ToString
@Builder
@NoArgsConstructor @AllArgsConstructor
@Table(name = "skill")
public class Skill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id", nullable = false)
    @JsonProperty("skill_id")
    private Long id;

    @Column(name = "skill_description")
    @JsonProperty("skill_description")
    private String skillDescription;

    @Column(name = "skill_name")
    @JsonProperty("skill_name")
    private String skillName;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @JsonProperty("type")
    private SkillType type;



}