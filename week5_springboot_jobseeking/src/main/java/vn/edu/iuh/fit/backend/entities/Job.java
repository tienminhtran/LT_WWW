package vn.edu.iuh.fit.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "job")
public class Job implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id", nullable = false)
    private Long id;

    @Column(name = "job_desc", nullable = false, length = 2000)
    private String jobDesc;

    @Column(name = "job_name", nullable = false)
    private String jobName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "com_id")
    private Company company;

    @OneToMany(mappedBy = "job", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<JobSkill> jobSkills;

    public Job(Long id, String jobDesc, String jobName, Company company) {
        this.id = id;
        this.jobDesc = jobDesc;
        this.jobName = jobName;
        this.company = company;
    }

    public Job(String jobDesc, String jobName, Company company) {
        this.jobDesc = jobDesc;
        this.jobName = jobName;
        this.company = company;
    }
}