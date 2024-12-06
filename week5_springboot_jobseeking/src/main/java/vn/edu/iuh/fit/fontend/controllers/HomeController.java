/*
 * @ {#} HomeController.java   1.0     12/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.fontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.Company;
import vn.edu.iuh.fit.backend.services.CandidateService;
import vn.edu.iuh.fit.backend.services.CompanyService;


@Controller
@SessionAttributes("email")
public class HomeController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CandidateService candidateService;
    @GetMapping("/")
    public String showIndex() {
        return "index";
    }
    // Truy cập trang login
    @GetMapping("/login")
    public String login() {
        return "home/login"; // Trang login
    }


    @PostMapping("/login")
    public String login(@RequestParam("email") String email, Model model) {
        Candidate candidate = candidateService.findByEmail(email);
        Company company = companyService.findByEmail(email);
        if (candidate != null) {
            model.addAttribute("email", email);
            return "redirect:/jobs/recommendations"; // tra ve request /jobs/recommendations
        }
        if (company != null) {
            model.addAttribute("email", email);
            return "redirect:/jobs/list"; // tra ve request /jobs/list
        }
        model.addAttribute("error", "Không tìm thấy ứng viên hoặc công ty với email: " + email);
        return "home/login"; // Trang login
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Hủy session hiện tại
        return "redirect:/login"; // Chuyển hướng tới trang login
    }


}
