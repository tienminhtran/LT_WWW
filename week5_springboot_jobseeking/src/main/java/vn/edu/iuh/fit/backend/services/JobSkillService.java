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

/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
@Service
public class JobSkillService {
    @Autowired
    private JobSkillRepository jobSkillRepository;

    // Lưu thông tin kỹ năng công việc
    public void save(JobSkill jobSkill) {
        jobSkillRepository.save(jobSkill);
    }
    // Tìm kỹ năng công việc theo công việc
    public List<JobSkill> findByJob(Job job) {
        return jobSkillRepository.findByJob(job);
    }
}
