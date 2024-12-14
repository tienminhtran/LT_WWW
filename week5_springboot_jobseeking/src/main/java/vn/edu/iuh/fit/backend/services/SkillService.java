/*
 * @ {#} SkillService.java   1.0     08/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Skill;
import vn.edu.iuh.fit.backend.repositories.SkillRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;
    // Tìm tất cả kỹ năng và lấy ra 5 kỹ năng
    public List<Skill> findAll() {
        return skillRepository.findAll().stream()
                .sorted(Comparator.comparing(Skill::getId))
                .limit(5)
                .collect(Collectors.toList());
    }
    // Tìm kỹ năng theo id
    public Skill findById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }
    // Gợi ý kỹ năng cho ứng viên dựa vào kỹ năng đã có của ứng viên
    public List<Skill> recommendSkillsForCandidate(Long candidateId) {
        Pageable pageable = PageRequest.of(0, 5);  // Lấy tối đa 5 kỹ năng
        return skillRepository.findSkillsNotInCandidateSkills(candidateId, pageable);
    }
    // Lưu thông tin kỹ năng
    public void save(Skill skill) {
        skillRepository.save(skill);
    }
    // Tìm kỹ năng theo tên
    public Skill findBySkillName(String skillName) {
        return skillRepository.findBySkillName(skillName);
    }
}
