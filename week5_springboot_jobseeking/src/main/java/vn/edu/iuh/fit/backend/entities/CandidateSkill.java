package vn.edu.iuh.fit.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import vn.edu.iuh.fit.backend.converters.SkillLevelConverter;
import vn.edu.iuh.fit.backend.enums.SkillLevel;
import vn.edu.iuh.fit.backend.ids.CandidateSkillId;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "candidate_skill")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CandidateSkill implements Serializable {

    @EmbeddedId
    private CandidateSkillId id;

    @MapsId("skillId")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_id")
    @JsonProperty("skill")
    private Skill skill;

    @MapsId("canId")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "can_id")
    @JsonIgnore
    private Candidate candidate;

    @Column(name = "skill_level", nullable = false)
    @Convert(converter = SkillLevelConverter.class)
    @JsonProperty("skill_level")
    private SkillLevel skillLevel;

    @Column(name = "more_infos", length = 1000)
    @JsonProperty("more_infos")
    private String moreInfo;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CandidateSkill that = (CandidateSkill) o;
        return getSkill() != null && Objects.equals(getSkill(), that.getSkill())
                && getCandidate() != null && Objects.equals(getCandidate(), that.getCandidate());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(skill, candidate);
    }
}