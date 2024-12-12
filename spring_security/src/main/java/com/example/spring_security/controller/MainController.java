package com.example.spring_security.controller;

import com.example.spring_security.entity.Member;
import com.example.spring_security.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    MemberService memberService;



    @GetMapping("/")
    public String home() {

        return "main";
    }

    @GetMapping("/p1")
    public String p1() {

        return "p1";
    }

    @GetMapping("/p2")
    public String p2() {
        return "p2";
    }

    @GetMapping("/registForm")
    public String registForm() {
        return "register-member";
    }

    @PostMapping("/regist")
    public String regist(Member member) {

        //DB에 저장
        int result = memberService.addMember(member);

        if(result == 1) {
            return "redirect:/login";
        }

        return "redirect:/";

    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }



    @GetMapping("/admin/adminpage")
    public String adminPage(){
        return "/admin/adminpage";
    }

}

