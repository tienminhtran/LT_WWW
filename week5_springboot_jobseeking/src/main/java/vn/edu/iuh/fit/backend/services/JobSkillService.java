/*
 * @ {#} JobSkillService.java   1.0     08/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.models.JobSkill;
import vn.edu.iuh.fit.backend.repositories.JobSkillRepository;

import java.util.List;


@Service
public class JobSkillService {
    @Autowired
    private JobSkillRepository jobSkillRepository;

    public void save(JobSkill jobSkill) {
        jobSkillRepository.save(jobSkill);
    }
    public List<JobSkill> findByJob(Job job) {
        return jobSkillRepository.findByJob(job);
    }
}
