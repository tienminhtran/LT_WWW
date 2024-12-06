/*
 * @ {#} JobRepository.java   1.0     07/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.Job;

import java.util.List;


@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findJobsByCompany_Email(String email);
    // Tìm các kỹ năng mà ứng viên có dựa trên email, sau đó tìm các công việc mà có ít nhất một trong các kỹ năng đó, trả về danh sách các công việc
    @Query("SELECT j FROM Job j WHERE EXISTS (" +
            "SELECT 1 FROM JobSkill js WHERE js.job = j " +
            "AND js.skill IN (SELECT cs.skill FROM CandidateSkill cs WHERE cs.can.email = :email))")
    List<Job> findRecommendedJobsForCandidate(@Param("email") String email);
}
