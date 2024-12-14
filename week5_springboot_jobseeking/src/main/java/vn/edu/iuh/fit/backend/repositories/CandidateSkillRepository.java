/*
 * @ {#} CandidateSkillRepository.java   1.0     12/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.backend.models.CandidateSkill;
import vn.edu.iuh.fit.backend.models.CandidateSkillId;

import java.util.List;

/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillId> {
    //Tim cac ky nang cua ung vien theo id ung vien va id ky nang
    CandidateSkill findByCanIdAndSkillId(Long canId, Long skillId);
    //Tim cac ky nang cua ung vien theo id ung vien
    List<CandidateSkill> findByCanId(Long canId);
    @Query("SELECT cs.skill.skillName, COUNT(cs) FROM CandidateSkill cs GROUP BY cs.skill.skillName ORDER BY COUNT(cs) DESC")
    //Tim cac ky nang co so luong ung vien co ky nang do nhieu nhat
    List<Object[]> findTopSkillsInCandidates();
}
