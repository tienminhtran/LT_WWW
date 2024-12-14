package vn.edu.iuh.fit.backend.models;

import java.io.Serializable;
import java.util.Objects;

public class JobSkillId implements Serializable {
    private Job job;
    private Skill skill;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobSkillId that)) return false;
        return Objects.equals(job, that.job) && Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, skill);
    }
}