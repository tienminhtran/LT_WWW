/*
 * @ {#} CandidateServices.java   1.0     06/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.*;
import vn.edu.iuh.fit.backend.repositories.*;

import java.util.ArrayList;
import java.util.List;

/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private ExperienceRepository experienceRepository;
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;
    @Autowired
    private SkillService skillService;

    // Tìm tất cả ứng viên theo trang
    public Page<Candidate> findAll(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return candidateRepository.findAll(pageable);
    }
    // Tìm ứng viên theo email
    public Candidate findByEmail(String email) {
        return candidateRepository.findByEmail(email).orElse(null);
    }
    // Tìm ứng viên phù hợp với công việc
    public List<Candidate> findCandidatesForJob(Job job) {
        List<Skill> requiredSkills = new ArrayList<>();
        // Lấy ra tất cả kỹ năng của công việc
        for (JobSkill jobSkill : job.getJobSkills()) {
            requiredSkills.add(jobSkill.getSkill());
        }
        return candidateRepository.findCandidatesWithSkills(requiredSkills);
    }
    // Tìm ứng viên theo id
    public Candidate findById(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }
    // Kiểm tra số điện thoại đã tồn tại chưa
    public boolean existsByPhone(String phone) {
        return candidateRepository.existsByPhone(phone);
    }
    // Kiểm tra email đã tồn tại chưa
    public boolean existsByEmail(String email) {
        return candidateRepository.existsByEmail(email);
    }
    // Kiểm tra tên đã tồn tại chưa
    public boolean existsByFullName(String fullName) {
        return candidateRepository.existsByFullName(fullName);
    }
    // Lưu ứng viên
    public void save(Candidate candidate) {
        Address address = candidate.getAddress();
        addressRepository.save(address);
        candidate.setAddress(address);
        candidateRepository.save(candidate);
    }
    // Cập nhật ứng viên
    public void saveCandidate(Candidate candidate) {
        Address address = candidate.getAddress();
        if (address != null) {
            addressRepository.save(address);
            candidate.setAddress(address);
            candidateRepository.save(candidate);
        }

        for (CandidateSkill candidateSkill : candidate.getCandidateSkills()) {
            Skill skill = candidateSkill.getSkill();

            if (skill.getId() == null || !skillRepository.existsById(skill.getId())) {
                skillRepository.save(skill);
            }
            CandidateSkillId id = new CandidateSkillId();
            id.setCanId(candidate.getId());
            id.setSkillId(skill.getId());

            candidateSkill.setId(id);
            candidateSkill.setCan(candidate);
            candidateSkill.setSkill(skill);
            System.out.println("Candidate: " + candidateSkill.getCan().getFullName());
            System.out.println("Skill: " + candidateSkill.getSkill().getSkillName());

            candidateSkillRepository.save(candidateSkill);
        }

        for (Experience experience : candidate.getExperiences()) {
            experience.setCandidate(candidate);
            experienceRepository.save(experience);
        }
        candidateRepository.save(candidate);
    }
    // Cập nhật ứng viên
    public void updateCandidate(Candidate candidate) {
        Address address = candidate.getAddress();
        if (address != null) {
            addressRepository.save(address);
            candidate.setAddress(address);
        }

        for (CandidateSkill candidateSkill : candidate.getCandidateSkills()) {
            Skill skill = candidateSkill.getSkill();

            if (skill.getId() == null || !skillRepository.existsById(skill.getId())) {
                skillRepository.save(skill);
            }
            CandidateSkillId id = new CandidateSkillId();
            id.setCanId(candidate.getId());
            id.setSkillId(skill.getId());

            candidateSkill.setId(id);
            candidateSkill.setCan(candidate);
            candidateSkill.setSkill(skill);
            System.out.println("Candidate: " + candidateSkill.getCan().getFullName());
            System.out.println("Skill: " + candidateSkill.getSkill().getSkillName());

            candidateSkillRepository.save(candidateSkill);
        }

        for (Experience experience : candidate.getExperiences()) {
            experience.setCandidate(candidate);
            experienceRepository.save(experience);
        }
        candidateRepository.save(candidate);
    }
}
