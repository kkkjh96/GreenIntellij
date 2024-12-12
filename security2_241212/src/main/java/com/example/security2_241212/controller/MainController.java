package com.example.security2_241212.controller;

import com.example.security2_241212.entity.Member;
import com.example.security2_241212.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private final MemberService memberService;

    public MainController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String root(){

        return "main";

    }

    @GetMapping("/registForm")
    public String registForm(){

        return "registForm";

    }

    @PostMapping("/registProc")
    public String registProc(Member member){

        memberService.regist(member);

        return "redirect:/loginForm";

    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

}
