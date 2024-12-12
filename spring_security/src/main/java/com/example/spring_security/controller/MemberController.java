package com.example.spring_security.controller;

import com.example.spring_security.security.CustomUserDetails;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@Controller
@RequestMapping("/members")
public class MemberController {

    @GetMapping("/mypage1")
    public String myPage1(Model model) {

        //시큐리티가 관리하고 있는 세션 객체
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("password", userDetails.getPassword());
        model.addAttribute("name", userDetails.getName());
        model.addAttribute("role", userDetails.getRole());

        return "/members/mypage";
    }

    @GetMapping("/mypage2")
    public String myPage2(Model model, Principal principal) {

        // 아이디를 출력해준다.
        model.addAttribute("username", principal.getName());

        model.addAttribute("principal", principal.toString());

        return "/members/mypage";
    }

    @GetMapping("/mypage3")
    public String myPage3(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails,
                          HttpSession session) {

        model.addAttribute("username", customUserDetails.getUsername());
        model.addAttribute("password", customUserDetails.getPassword());
        model.addAttribute("name", customUserDetails.getName());
        model.addAttribute("role", customUserDetails.getRole());

//        session.setAttribute("username", customUserDetails.getUsername());

        return "/members/mypage";
    }

}
