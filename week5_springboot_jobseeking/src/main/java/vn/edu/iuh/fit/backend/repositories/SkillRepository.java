/*
 * @ {#} SkillRepository.java   1.0     08/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.Skill;

import java.util.List;

/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    // Tìm các kỹ năng mà ứng viên có dựa trên id của ứng viên,
    // sau đó tìm các kỹ năng mà không có trong danh sách kỹ năng của ứng viên,
    // trả về danh sách các kỹ năng
    @Query("SELECT s FROM Skill s WHERE s NOT IN " +
            "(SELECT cs.skill FROM CandidateSkill cs WHERE cs.can.id = :candidateId)")
    List<Skill> findSkillsNotInCandidateSkills(@Param("candidateId") Long candidateId, Pageable pageable);
    // Tìm kỹ năng theo tên kỹ năng
    Skill findBySkillName(String skillName);
}
