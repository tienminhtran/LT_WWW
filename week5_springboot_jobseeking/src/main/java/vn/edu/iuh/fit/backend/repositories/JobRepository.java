/*
 * @ {#} JobRepository.java   1.0     07/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.Job;

import java.util.List;

/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    // Tìm công việc theo email của công ty
    List<Job> findJobsByCompany_Email(String email);
    // Tìm các kỹ năng mà ứng viên có dựa trên email,
    // sau đó tìm các công việc mà có ít nhất một trong các kỹ năng đó,
    // trả về danh sách các công việc
    @Query("SELECT j FROM Job j WHERE EXISTS (" +
            "SELECT 1 FROM JobSkill js WHERE js.job = j " +
            "AND js.skill IN (SELECT cs.skill FROM CandidateSkill cs WHERE cs.can.email = :email))")
    List<Job> findRecommendedJobsForCandidate(@Param("email") String email);
    // Tìm các công việc theo tên công việc, tên công ty hoặc tên kỹ năng
    Page<Job> findByJobNameContainingIgnoreCaseOrCompany_CompNameContainingIgnoreCaseOrJobSkills_Skill_SkillNameContainingIgnoreCase(
            String jobName, String companyName, String skillName, Pageable pageable);
    @Query("SELECT j FROM Job j " +
            "JOIN j.jobSkills js " +
            "WHERE j.company.id = :companyId " +
            "AND (LOWER(j.jobName) LIKE LOWER(CONCAT('%', :query, '%')) " +
            "OR LOWER(js.skill.skillName) LIKE LOWER(CONCAT('%', :query, '%')))")
    // Tìm các công việc theo tên công việc hoặc tên kỹ năng
    List<Job> searchByJobNameOrSkillName(@Param("query") String query, @Param("companyId") Long companyId);
}
