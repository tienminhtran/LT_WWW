package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.backend.converters.SkillLevelConverter;
import vn.edu.iuh.fit.backend.enums.SkillLevel;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "job_skill")
@IdClass(JobSkillId.class)
public class JobSkill {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @Column(name = "more_infos", length = 1000)
    private String moreInfos;

    @Column(name = "skill_level", nullable = false)
    @Convert(converter = SkillLevelConverter.class)
    private SkillLevel skillLevel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobSkill jobSkill = (JobSkill) o;
        return Objects.equals(job, jobSkill.job) && Objects.equals(skill, jobSkill.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, skill);
    }
}