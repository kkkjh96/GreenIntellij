package com.example.demo.controller;

import com.example.demo.dto.CustomSessionUser;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    CustomSessionUser customSession;;

    @GetMapping("/")
    public String root(){
        return "main";
    }

    @GetMapping("/regist")
    public String regist(Model model){
        model.addAttribute("user", new UserDto());
        return "signUp";
    }

    @PostMapping("/login")
    public String signup(UserDto user, Model model){
        System.out.println("user " + user);
        userService.regist(user);
        System.out.println("User ");
        model.addAttribute("user", new UserDto());
        return "login";
    }

    @GetMapping("/sign")
    public String sign(Model model){
        // 로그인 로직
        model.addAttribute("user", new UserDto());
        return "login";
    }

    @PostMapping("/loginUser")
    public String loginUser(UserDto user, HttpSession session, HttpServletResponse response, Model model) throws Exception {
        // 로그인 로직
        UserDto u =  userService.getUser(user);
        System.out.println("user " + u);

        customSession.setUser(u);
        session.setAttribute("user", u);

//        model.addAttribue("userDto", u);
        return "main" ;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        System.out.println(customSession.getUser());
        session.invalidate();
        return "redirect:/";
    }


}
