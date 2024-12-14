/*
 * @ {#} SkillController.java   1.0     13/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.fontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.edu.iuh.fit.backend.models.Skill;
import vn.edu.iuh.fit.backend.services.SkillService;

import java.util.List;

/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
@Controller
@RequestMapping("/skills")
public class SkillController {
    @Autowired
    private SkillService skillService;
    // Hiển thị danh sách kỹ năng được đề xuất cho ứng viên
    @GetMapping("/recommend/{candidateId}")
    public String recommendSkills(@PathVariable Long candidateId, Model model) {
        List<Skill> recommendedSkills = skillService.recommendSkillsForCandidate(candidateId);
        model.addAttribute("recommendedSkills", recommendedSkills);
        return "skills/skill-recommendations";
    }
}
