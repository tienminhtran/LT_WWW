/*
 * @ {#} JobService.java   1.0     07/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.dtos.JobDTO;
import vn.edu.iuh.fit.backend.models.*;
import vn.edu.iuh.fit.backend.repositories.*;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private JobSkillRepository jobSkillRepository;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;
    public List<Job> findAll() {
        return jobRepository.findAll();
    }
    public List<Job> findByCompanyWithEmail(String email) {
        return jobRepository.findJobsByCompany_Email(email);
    }
    public Job save(JobDTO jobDTO) {
        Company company = companyRepository.findById(jobDTO.getCompanyId()).orElse(null);
        Job job = new Job();
        job.setJobName(jobDTO.getJobName());
        job.setJobDesc(jobDTO.getJobDesc());
        job.setCompany(company);
        Job savedJob = jobRepository.save(job);
        for (Long skillId : jobDTO.getSkillIds()) {
            Skill skill = skillRepository.findById(skillId).orElse(null);
            JobSkill jobSkill = new JobSkill();
            JobSkillId jobSkillId = new JobSkillId();
            jobSkillId.setJobId(savedJob.getId());
            jobSkillId.setSkillId(skill.getId());
            jobSkill.setId(jobSkillId);
            jobSkill.setJob(savedJob);
            jobSkill.setSkill(skill);
            jobSkill.setSkillLevel((byte)1);
            jobSkill.setMoreInfos("More info");
            jobSkillRepository.save(jobSkill);
        }
        return savedJob;
    }
    public Job findById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }
    public List<Job> recommendJobsForCandidate(String email) {
        return jobRepository.findRecommendedJobsForCandidate(email);
    }
}
