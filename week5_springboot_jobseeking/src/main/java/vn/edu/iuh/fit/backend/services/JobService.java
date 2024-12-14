/*
 * @ {#} JobService.java   1.0     07/11/2024
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
import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.repositories.JobRepository;

import java.util.List;

/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    // Tìm tất cả công việc theo trang
    public Page<Job> findAll(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return jobRepository.findAll(pageable);
    }
    // Tìm công việc theo email của công ty
    public List<Job> findByCompanyWithEmail(String email) {
        return jobRepository.findJobsByCompany_Email(email);
    }
    // Tìm các công việc theo tên công việc, tên công ty hoặc tên kỹ năng
    public Page<Job> searchJobs(String search, Pageable pageable) {
        if (search == null || search.trim().isEmpty()) {
            return jobRepository.findAll(pageable);
        }
        return jobRepository.findByJobNameContainingIgnoreCaseOrCompany_CompNameContainingIgnoreCaseOrJobSkills_Skill_SkillNameContainingIgnoreCase(search, search, search, pageable);
    }
    // Lưu thông tin công việc
    public Job save(Job job) {
        return jobRepository.save(job);
    }
    // Tìm công việc theo id
    public Job findById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }
    // Gợi ý công việc cho ứng viên
    public List<Job> recommendJobsForCandidate(String email) {
        return jobRepository.findRecommendedJobsForCandidate(email);
    }
    // Xóa công việc theo id
    public void deleteJobById(Long id) {
        jobRepository.deleteById(id);
    }
    // Tìm công việc theo tên công việc hoặc tên kỹ năng
    public List<Job> searchJobs(String query, Long companyId) {
        return jobRepository.searchByJobNameOrSkillName(query, companyId);
    }
}
