/*
 * @ {#} CandidateController.java   1.0     06/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.fontend.controllers;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.backend.enums.SkillType;
import vn.edu.iuh.fit.backend.models.*;
import vn.edu.iuh.fit.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.backend.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.backend.repositories.ExperienceRepository;
import vn.edu.iuh.fit.backend.services.CandidateService;
import vn.edu.iuh.fit.backend.services.SkillService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
@Controller
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private ExperienceRepository experienceRepository;
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;

    // Hiển thị danh sách ứng viên
    @GetMapping("/list")
    public String showCandidateList(Model model) {
        model.addAttribute("candidates", candidateRepository.findAll());
        return "candidates/candidates";
    }
    // Hiển thị danh sách ứng viên theo trang
    @GetMapping("/candidates")
    public String showCandidateListPaging(Model model,
                                          @RequestParam("page") Optional<Integer> page,
                                          @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Candidate> candidatePage = candidateService.findAll(
                currentPage - 1, pageSize, "id", "asc");
        model.addAttribute("candidatePage", candidatePage);
        int totalPages = candidatePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "candidates/candidates-paging";
    }

    // Hiển thị trang đăng ký ứng viên
    @GetMapping("/signup")
    public String signupForm(Model model) {
        List<CountryCode> countries = List.of(CountryCode.values());
        List<Skill> skills = skillService.findAll();
        model.addAttribute("candidate", new Candidate());
        model.addAttribute("countries", countries);
        model.addAttribute("skills", skills);
        return "home/signup";
    }

    // Xử lý đăng ký ứng viên
    @PostMapping("/signup")
    public String createCandidate(@ModelAttribute Candidate candidate,
                                  @RequestParam List<Long> skillIds,
                                  @RequestParam List<Byte> skillLevels,
                                  @RequestParam(required = false) List<String> newSkillNames,
                                  @RequestParam(required = false) List<Byte> newSkillLevels,
                                  @RequestParam(required = false) List<String> newSkillMoreInfos,
                                  RedirectAttributes redirectAttributes) {
        // Kiểm tra số điện thoại đã tồn tại
        if (candidateService.existsByPhone(candidate.getPhone())) {
            redirectAttributes.addFlashAttribute("errorMessage", "Phone number already exists!");
            return "redirect:/signup"; // Quay lại trang đăng ký
        }

        // Kiểm tra email đã tồn tại
        if (candidateService.existsByEmail(candidate.getEmail())) {
            redirectAttributes.addFlashAttribute("errorMessage", "Email already exists!");
            return "redirect:/signup"; // Quay lại trang đăng ký
        }

        // Kiểm tra tên đã tồn tại
        if (candidateService.existsByFullName(candidate.getFullName())) {
            redirectAttributes.addFlashAttribute("errorMessage", "Full name already exists!");
            return "redirect:/signup"; // Quay lại trang đăng ký
        }

        // Khởi tạo danh sách CandidateSkill nếu chưa có
        if (candidate.getCandidateSkills() == null) {
            candidate.setCandidateSkills(new ArrayList<>());
        }

        // Xử lý kỹ năng mới (nếu có)
        if (newSkillNames != null && !newSkillNames.isEmpty()) {
            for (int i = 0; i < newSkillNames.size(); i++) {
                String skillName = newSkillNames.get(i);
                Byte skillLevel = newSkillLevels != null ? newSkillLevels.get(i) : 1; // Nếu không có cấp độ, mặc định là 1
                String moreInfo = newSkillMoreInfos != null ? newSkillMoreInfos.get(i) : "";
                if (skillName != null && !skillName.trim().isEmpty()) {
                    // Kiểm tra nếu kỹ năng chưa có trong cơ sở dữ liệu
                    Skill existingSkill = skillService.findBySkillName(skillName.trim());
                    Skill newSkill = null;

                    if (existingSkill == null) {
                        // Nếu kỹ năng chưa có, tạo mới
                        newSkill = new Skill();
                        newSkill.setSkillName(skillName);
                        newSkill.setSkillDescription("A programming language used for development of software.");
                        newSkill.setType(SkillType.SOFT_SKILL);
                        skillService.save(newSkill); // Lưu kỹ năng mới vào cơ sở dữ liệu
                    } else {
                        newSkill = existingSkill; // Nếu đã có, sử dụng kỹ năng hiện tại
                    }

                    // Tạo đối tượng CandidateSkill cho kỹ năng mới
                    CandidateSkill candidateSkill = new CandidateSkill();
                    CandidateSkillId candidateSkillId = new CandidateSkillId();
                    candidateSkillId.setCanId(candidate.getId());
                    candidateSkillId.setSkillId(newSkill.getId());
                    candidateSkill.setId(candidateSkillId);
                    candidateSkill.setCan(candidate);
                    candidateSkill.setSkill(newSkill);
                    candidateSkill.setSkillLevel(skillLevel);
                    candidateSkill.setMoreInfos(moreInfo);

                    // Thêm vào danh sách CandidateSkill của Candidate
                    candidate.getCandidateSkills().add(candidateSkill);
                }
            }
        }

        // Lặp qua các kỹ năng đã có trong form và lưu
        for (int i = 0; i < skillIds.size(); i++) {
            Long skillId = skillIds.get(i);
            Byte skillLevel = skillLevels.get(i);
            // Tìm Skill từ ID
            Skill skill = skillService.findById(skillId);
            // Tạo CandidateSkill cho kỹ năng đã chọn
            CandidateSkill candidateSkill = new CandidateSkill();
            CandidateSkillId candidateSkillId = new CandidateSkillId();
            candidateSkillId.setCanId(candidate.getId());
            candidateSkillId.setSkillId(skill.getId());
            candidateSkill.setId(candidateSkillId);
            candidateSkill.setCan(candidate);
            candidateSkill.setSkill(skill);
            candidateSkill.setSkillLevel(skillLevel);

            // Thêm vào danh sách CandidateSkill của Candidate
            candidate.getCandidateSkills().add(candidateSkill);
        }

        // Lưu đối tượng Candidate và CandidateSkill vào cơ sở dữ liệu
        candidateService.saveCandidate(candidate);
        redirectAttributes.addFlashAttribute("successMessage", "Candidate registered successfully!");
        return "redirect:/login";
    }

    // Hiển thị trang cập nhật ứng viên
    @GetMapping("/edit/{id}")
    public String editCandidateForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Candidate candidate = candidateService.findById(id);
        if (candidate == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Candidate not found!");
            return "redirect:/candidates"; // Hoặc trang phù hợp nếu Candidate không tồn tại
        }

        List<CountryCode> countries = List.of(CountryCode.values());
        List<Experience> experiences = candidate.getExperiences();
        if (experiences.isEmpty()) {
            experiences.add(new Experience()); // Thêm một bản ghi rỗng
        }
        List<Skill> skills = skillService.findAll();

        model.addAttribute("candidate", candidate);
        model.addAttribute("countries", countries);
        model.addAttribute("skills", skills);

        return "candidates/edit-candidate"; // Trang HTML để chỉnh sửa
    }

    // Xử lý cập nhật ứng viên
    @PostMapping("/edit/{id}")
    public String updateCandidate(
            @PathVariable Long id,
            @ModelAttribute Candidate updatedCandidate,
            @RequestParam(required = false) List<Long> skillIds,
            @RequestParam(required = false) List<Byte> skillLevels,
            @RequestParam(required = false) List<String> moreInfos,
            @RequestParam(required = false) List<String> newSkillNames,
            @RequestParam(required = false) List<Byte> newSkillLevels,
            @RequestParam(required = false) List<String> newSkillMoreInfos,
            RedirectAttributes redirectAttributes) {


        Candidate existingCandidate = candidateService.findById(id);
        if (existingCandidate == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Candidate not found!");
            return "redirect:/candidates";
        }

        // Cập nhật thông tin cơ bản (các phần đã có)
        existingCandidate.setFullName(updatedCandidate.getFullName());
        existingCandidate.setDob(updatedCandidate.getDob());
        existingCandidate.setEmail(updatedCandidate.getEmail());
        existingCandidate.setPhone(updatedCandidate.getPhone());

        // Cập nhật kỹ năng đã chọn (nếu có)
        if (skillIds != null && !skillIds.isEmpty()) {
            for (int i = 0; i < skillIds.size(); i++) {
                Long skillId = skillIds.get(i);
                Byte skillLevel = skillLevels.get(i);
                String moreInfo = (moreInfos != null && moreInfos.size() > i) ? moreInfos.get(i) : ""; // Lấy moreInfos


                Skill skill = skillService.findById(skillId);

                // Tìm kỹ năng của ứng viên và cập nhật mức độ và thông tin thêm
                CandidateSkill existingCandidateSkill = candidateSkillRepository.findByCanIdAndSkillId(existingCandidate.getId(), skill.getId());

                if (existingCandidateSkill != null) {
                    existingCandidateSkill.setSkillLevel(skillLevel);
                    existingCandidateSkill.setMoreInfos(moreInfo);
                    candidateSkillRepository.save(existingCandidateSkill); // Lưu lại thay đổi
                } else {
                    // Nếu không tìm thấy, thêm kỹ năng mới vào
                    CandidateSkill candidateSkill = new CandidateSkill();
                    CandidateSkillId candidateSkillId = new CandidateSkillId();
                    candidateSkillId.setCanId(existingCandidate.getId());
                    candidateSkillId.setSkillId(skill.getId());
                    candidateSkill.setId(candidateSkillId);
                    candidateSkill.setCan(existingCandidate);
                    candidateSkill.setSkill(skill);
                    candidateSkill.setSkillLevel(skillLevel);
                    candidateSkill.setMoreInfos(moreInfo);

                    existingCandidate.getCandidateSkills().add(candidateSkill);
                }

            }
        }

        // Thêm các kỹ năng mới (nếu có)
        if (newSkillNames != null && !newSkillNames.isEmpty()) {
            for (int i = 0; i < newSkillNames.size(); i++) {
                String skillName = newSkillNames.get(i);
                Byte skillLevel = (newSkillLevels != null && newSkillLevels.size() > i) ? newSkillLevels.get(i) : 1;
                String moreInfo = (newSkillMoreInfos != null && newSkillMoreInfos.size() > i) ? newSkillMoreInfos.get(i) : "";

                // Kiểm tra xem kỹ năng đã tồn tại chưa, nếu chưa thì thêm mới
                Skill newSkill = skillService.findBySkillName(skillName.trim());
                if (newSkill == null) {
                    newSkill = new Skill();
                    newSkill.setSkillName(skillName);
                    newSkill.setSkillDescription("A programming language used for development of software.");
                    skillService.save(newSkill); // Lưu kỹ năng mới vào DB
                }

                // Tạo và thêm mới vào danh sách kỹ năng của ứng viên
                CandidateSkill candidateSkill = new CandidateSkill();
                CandidateSkillId candidateSkillId = new CandidateSkillId();
                candidateSkillId.setCanId(existingCandidate.getId());
                candidateSkillId.setSkillId(newSkill.getId());
                candidateSkill.setId(candidateSkillId);
                candidateSkill.setCan(existingCandidate);
                candidateSkill.setSkill(newSkill);
                candidateSkill.setSkillLevel(skillLevel);
                candidateSkill.setMoreInfos(moreInfo);

                existingCandidate.getCandidateSkills().add(candidateSkill);
                candidateSkillRepository.save(candidateSkill);
            }
        }

        // Cập nhật danh sách kinh nghiệm (các phần đã có)
        List<Experience> updatedExperiences = updatedCandidate.getExperiences();
        List<Experience> existingExperiences = existingCandidate.getExperiences();

        for (int i = 0; i < updatedExperiences.size(); i++) {
            Experience updatedExperience = updatedExperiences.get(i);
            Experience existingExperience = (i < existingExperiences.size()) ? existingExperiences.get(i) : null;

            if (existingExperience == null) {
                existingExperience = new Experience();
                existingExperiences.add(existingExperience);
            }

            existingExperience.setCompanyName(updatedExperience.getCompanyName());
            existingExperience.setRole(updatedExperience.getRole());
            existingExperience.setFromDate(updatedExperience.getFromDate());
            existingExperience.setToDate(updatedExperience.getToDate());
            existingExperience.setWorkDescription(updatedExperience.getWorkDescription());
            existingExperience.setCandidate(existingCandidate);

            experienceRepository.save(existingExperience);
        }

        candidateService.updateCandidate(existingCandidate);

        redirectAttributes.addFlashAttribute("successMessage", "Candidate updated successfully!");
        return "redirect:/jobs/recommendations"; // Quay lại trang gợi ý công việc
    }
}
