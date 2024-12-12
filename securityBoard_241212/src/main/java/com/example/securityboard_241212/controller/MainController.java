package com.example.securityboard_241212.controller;

import com.example.securityboard_241212.dto.MemberDto;
import com.example.securityboard_241212.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * packageName    : com.example.securityboard_241212.controller
 * fileName       : MainController
 * author         : 김재홍
 * date           : 24. 12. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 12.        김재홍       최초 생성
 */
@Controller
public class MainController {

    @Autowired
    MemberService memberService;

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/regist")
    public String regist() {
        return "registForm";
    }

    @PostMapping("/regist")
    public String registProc(MemberDto member) {

        memberService.insertMember(member);  // 회원가입

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
