/*
 * @ {#} CompanyController.java   1.0     29/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.fontend.controllers;

import com.neovisionaries.i18n.CountryCode;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.backend.models.Company;
import vn.edu.iuh.fit.backend.services.CompanyService;

import java.util.Arrays;
import java.util.List;

/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
@Controller
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    // Hiển thị trang đăng ký công ty
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("company", new Company());

        // Load danh sách các quốc gia từ thư viện CountryCode
        List<CountryCode> countries = Arrays.asList(CountryCode.values());
        model.addAttribute("countries", countries);

        return "home/signUpCompany";
    }
    // XỬ lý đăng ký công ty
    @PostMapping("/register")
    public String registerCompany(
            @ModelAttribute("company") Company company,
            RedirectAttributes redirectAttributes) {

        try {
            if (companyService.existsByEmail(company.getEmail())) {
                // Thêm thông báo lỗi nếu email đã tồn tại
                redirectAttributes.addFlashAttribute("errorMessage", "Email already exists!");
                return "redirect:/companies/register";
            }
            if (companyService.existsByPhone(company.getPhone())) {
                // Thêm thông báo lỗi nếu số điện thoại đã tồn tại
                redirectAttributes.addFlashAttribute("errorMessage", "Phone number already exists!");
                return "redirect:/companies/register";
            }
            // Lưu thông tin công ty vào cơ sở dữ liệu
            companyService.save(company);

            // Thêm thông báo thành công
            redirectAttributes.addFlashAttribute("successMessage", "Company registered successfully!");

            // Chuyển hướng về trang chủ hoặc trang danh sách công ty
            return "redirect:/login";

        } catch (Exception e) {
            // Thêm thông báo lỗi nếu có vấn đề xảy ra
            redirectAttributes.addFlashAttribute("errorMessage", "Error occurred while registering the company: " + e.getMessage());

            // Quay lại trang đăng ký nếu có lỗi
            return "home/signUpCompany";
        }
    }
    // Hiển thị trang chỉnh sửa thông tin công ty
    @GetMapping("/edit/{id}")
    public String showEditCompanyForm(@PathVariable("id") Long id, Model model) {
        Company company = companyService.findById(id);
        if (company == null) {
            throw new RuntimeException("Company not found!");
        }
        model.addAttribute("company", company);

        // Danh sách quốc gia
        List<CountryCode> countries = Arrays.asList(CountryCode.values());
        model.addAttribute("countries", countries);

        return "companies/form-edit-company";
    }
    // Xử lý chỉnh sửa thông tin công ty
    @PostMapping("/edit/{id}")
    public String editCompany(
            @PathVariable Long id,
            @ModelAttribute("company") Company updatedCompany,
            HttpSession session,
            RedirectAttributes redirectAttributes) {
        try {
            // Tìm công ty trong cơ sở dữ liệu
            Company existingCompany = companyService.findById(id);
            if (existingCompany == null) {
                redirectAttributes.addFlashAttribute("message", "Company not found!");
                return "redirect:/jobs/list";
            }

            // Cập nhật thông tin công ty
            existingCompany.setCompName(updatedCompany.getCompName());
            existingCompany.setEmail(updatedCompany.getEmail());
            existingCompany.setPhone(updatedCompany.getPhone());
            existingCompany.setAbout(updatedCompany.getAbout());
            existingCompany.setWebUrl(updatedCompany.getWebUrl());
            existingCompany.setAddress(updatedCompany.getAddress());

            // Lưu vào cơ sở dữ liệu
            companyService.save(existingCompany);

            // Cập nhật email trong session
            session.setAttribute("email", existingCompany.getEmail());

            // Thông báo thành công
            redirectAttributes.addFlashAttribute("message", "Company updated successfully!");
            return "redirect:/jobs/list";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Error updating company: " + e.getMessage());
            return "redirect:/companies/edit/" + id;
        }
    }


}
