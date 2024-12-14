/*
 * @ {#} JobSkillRepository.java   1.0     08/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.models.JobSkill;

import java.util.List;

/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill, Long> {
    // Tim cac ky nang cua cong viec theo cong viec
    List<JobSkill> findByJob(Job job);
    @Query("SELECT js.skill.skillName, COUNT(js) FROM JobSkill js GROUP BY js.skill.skillName ORDER BY COUNT(js) DESC")
    // Tim cac ky nang co so luong cong viec co ky nang do nhieu nhat
    List<Object[]> findTopSkillsInJobs();
}
