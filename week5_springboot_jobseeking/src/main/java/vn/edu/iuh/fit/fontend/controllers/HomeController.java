/*
 * @ {#} HomeController.java   1.0     12/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.fontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.Company;
import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.services.CandidateService;
import vn.edu.iuh.fit.backend.services.CompanyService;
import vn.edu.iuh.fit.backend.services.JobService;

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
@SessionAttributes("email")
public class HomeController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private JobService jobService;
    // Truy cập trang login
    @GetMapping("/login")
    public String login() {
        return "home/login"; // Trang login
    }
    // Xử lý đăng nhập
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
        model.addAttribute("error", "No candidate or company found with email: " + email);
        return "home/login"; // Trang login
    }
    // Xử lý đăng xuất
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Hủy session hiện tại
        return "redirect:/login"; // Chuyển hướng tới trang login
    }
    // Truy cập trang đăng ký
    @GetMapping("/")
    public String showJobListPaging(Model model,
                                    @RequestParam("page") Optional<Integer> page,
                                    @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(12);
        Page<Job> jobPage= jobService.findAll(
                currentPage - 1,pageSize,"id","asc");
        model.addAttribute("jobPage", jobPage);
        int totalPages = jobPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "index";
    }

    // Tìm kiếm công việc theo tên công việc hoặc tên công ty hoặc kỹ năng
    @GetMapping("/search")
    public String searchJobs(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size,
            Model model) {
        Page<Job> jobPage = jobService.searchJobs(search, PageRequest.of(page, size));
        model.addAttribute("jobPage", jobPage);

        model.addAttribute("search", search);
        model.addAttribute("pageNumbers", IntStream.rangeClosed(1, jobPage.getTotalPages())// tạo ra một chuỗi số từ 1 đến tổng số trang
                .boxed() // chuyển từ IntStream sang Stream<Integer>
                .collect(Collectors.toList())); // chuyển Stream<Integer> thành List<Integer>
        return "index";
    }


}
