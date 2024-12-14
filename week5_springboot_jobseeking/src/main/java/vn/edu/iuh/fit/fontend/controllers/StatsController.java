/*
 * @ {#} StatsController.java   1.0     08/12/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.fontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.edu.iuh.fit.backend.services.StatsService;

import java.util.Map;

/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
@Controller
@RequestMapping("/stats")
public class StatsController {
    @Autowired
    private StatsService statsService;  

    // Hiển thị trang thống kê
    @GetMapping
    public String showStats(Model model) {
        Map<String, Long> topSkillsInJobs = statsService.getTopSkillsInJobs();
        Map<String, Long> topSkillsInCandidates = statsService.getTopSkillsInCandidates();

        model.addAttribute("topSkillsInJobs", topSkillsInJobs);
        model.addAttribute("topSkillsInCandidates", topSkillsInCandidates);

        return "home/stats";
    }
}
