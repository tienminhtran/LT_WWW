/*
 * @ {#} JobController.java   1.0     07/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.fontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.backend.dtos.JobDTO;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.Company;
import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.models.JobSkill;
import vn.edu.iuh.fit.backend.services.*;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/jobs")
//@SessionAttributes("email")
public class JobController {
    @Autowired
    private JobService jobService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private JobSkillService jobSkillService;
    @Autowired
    private CandidateService candidateService;
//    @Autowired
//    private EmailService emailService;

    @GetMapping("/list")
    public String showJobPostings(@SessionAttribute("email") String email, Model model) {
        Company company = companyService.findByEmail(email);
        List<Job> jobPostings = jobService.findByCompanyWithEmail(email);
        for (Job job : jobPostings) {
            List<JobSkill> jobSkills = jobSkillService.findByJob(job);
            job.setJobSkills(jobSkills);
        }
        model.addAttribute("company", company);
        model.addAttribute("jobPostings", jobPostings);
        return "companies/dashboard-company";
    }

    @GetMapping("/new")
    public String showCreateJobForm(@SessionAttribute("email") String email, Model model) {
        Company company = companyService.findByEmail(email);
        JobDTO jobDTO = new JobDTO();
        jobDTO.setCompanyId(company.getId());
        model.addAttribute("jobDTO", jobDTO);
        model.addAttribute("skills", skillService.findAll());
        model.addAttribute("company", company);
        return "jobs/form-add-job";
    }

    @PostMapping("/save")
    public String saveJob(@ModelAttribute("jobDTO") JobDTO jobDTO) {
        jobService.save(jobDTO);
        return "redirect:/jobs/list"; // Điều hướng về trang danh sách sau khi lưu
    }

    @GetMapping("/details/{id}")
    public String getJobDetails(@PathVariable Long id, Model model) {
        Job job = jobService.findById(id);

        model.addAttribute("job", job);
        return "jobs/job-details";
    }

    @GetMapping("/recommendations")
    public String getJobRecommendations(@SessionAttribute("email") String email, Model model) {
        if (email != null) {
            List<Job> recommendedJobs = jobService.recommendJobsForCandidate(email);
            Candidate candidate = candidateService.findByEmail(email);
            model.addAttribute("candidate", candidate);
            model.addAttribute("jobs", recommendedJobs);
            model.addAttribute("email", email);
            return "candidates/dashboard-candidate";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/{jobId}/invite")
    public String showCandidatesForJob(@PathVariable Long jobId, Model model) {
        Job job = jobService.findById(jobId);
        List<Candidate> candidates = candidateService.findCandidatesForJob(job);
        model.addAttribute("job", job);
        model.addAttribute("candidates", candidates);
        return "jobs/invite-candidates";
    }
//    @PostMapping("/{jobId}/inviteCandidate/{candidateId}")
//    public String inviteCandidate(@PathVariable Long jobId, @PathVariable Long candidateId) {
//        Candidate candidate = candidateService.findById(candidateId);
//        if (candidate == null) {
//            throw new RuntimeException("Candidate not found");
//        }
//
//        Job job = jobService.findById(jobId);
//        if (job == null) {
//            throw new RuntimeException("Job not found");
//        }
//
//        String toEmail = candidate.getEmail();
//        String subject = "Job Invitation for " + job.getJobName();
//        String body = "Dear " + candidate.getFullName() + ",\n\n" +
//                "We are excited to invite you to apply for the position of " + job.getJobName() + " at our company. " +
//                "This role requires the following skills: " + job.getJobSkills().stream()
//                .map(skill -> skill.getSkill().getSkillName())
//                .collect(Collectors.joining(", ")) + ".\n\n" +
//                "Please let us know if you're interested.\n\nBest regards,\n" + job.getCompany().getCompName();
//
//        emailService.sendInvitationEmail(toEmail, subject, body);
//
//        return "redirect:/jobs/" + jobId + "/invite";
//    }

}
