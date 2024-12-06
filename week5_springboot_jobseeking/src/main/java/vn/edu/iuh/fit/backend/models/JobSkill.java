package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.backend.converters.SkillLevelConverter;
import vn.edu.iuh.fit.backend.enums.SkillLevel;
import vn.edu.iuh.fit.backend.ids.JobSkillId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "job_skill")
public class JobSkill {
    @EmbeddedId
    private JobSkillId id;

    @MapsId("jobId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id", nullable = false)
    @ToString.Exclude
    private Job job;

    @MapsId("skillId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @Column(name = "more_infos", length = 1000)
    private String moreInfos;

    @Column(name = "skill_level", nullable = false)
    @Convert(converter = SkillLevelConverter.class)
    private SkillLevel skillLevel;

}