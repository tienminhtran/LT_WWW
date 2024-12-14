/*
 * @ {#} CandidateRepository.java   1.0     06/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.Skill;

import java.util.List;
import java.util.Optional;

/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    // Tìm ứng viên theo email
    Optional<Candidate> findByEmail(String email);
    // Tìm các ứng viên có ít nhất một trong các kỹ năng được truyền vào
    @Query("SELECT c FROM Candidate c JOIN c.candidateSkills cs WHERE cs.skill IN :skills")
    List<Candidate> findCandidatesWithSkills(@Param("skills") List<Skill> skills);
    // Kiểm tra số điện thoại đã tồn tại chưa
    boolean existsByPhone(String phone);
    // Kiểm tra email đã tồn tại chưa
    boolean existsByEmail(String email);
    // Kiểm tra tên đã tồn tại chưa
    boolean existsByFullName(String fullName);
}
