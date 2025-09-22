package com.fit.controller;

import com.fit.util.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpRequest;
import java.security.Principal;

@Controller
public class MainController {

    //Trang home
    @RequestMapping(value = { "/","welcome"}, method = RequestMethod.GET)
    public String welcomePage(Model model,Principal principal) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");

        boolean isAuthenticated = principal != null; //Kiểm tra xem user đã đăng nhập chưa (principal != null)
        model.addAttribute("isAuthenticated", isAuthenticated);
        return "welcomePage";
    }

    //Trang user info sau khi login thanh cong
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // Sau khi user login thanh cong se co principal
        String userName = principal.getName(); //Lấy ra username của user đã đăng nhập

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();  //Lấy ra thông tin user đã đăng nhập

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("username", userName);

        return "userInfoPage";
    }

    //Trang login
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@RequestParam(value = "error", required = false) String error,Model model) {
        if(error != null){
            model.addAttribute("error", "Your username and password is invalid.");
        }
        return "loginPage";
    }
    //required = false : không bắt buộc phải có tham số error



    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {

        // Sau khi user login thanh cong se co principal
        String userName = principal.getName(); //Lấy ra username của user đã đăng nhập

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        //loginedUser là đối tượng User đã đăng nhập thành công gôm username, password, authorities
        //getPrincipal() trả về đối tượng User
        //Authorities là danh sách các quyền mà user đó có thể là admin, user, manager ...

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("username", userName);

        return "adminPage";
    }
    //Model gửi dữ liệu tới view
    //Principal là đối tượng đại diện cho người dùng hiện tại đang đăng nhập vào hệ thống




    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage() {
        return "logoutSuccessfulPage";
    }




    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }
        return "403Page";
    }




}
