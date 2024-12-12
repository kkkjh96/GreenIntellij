package com.example.security2_241212.service;

import com.example.security2_241212.entity.Member;

public interface MemberService {

    void regist(Member member);

    Member findByUserName(String username);
}
