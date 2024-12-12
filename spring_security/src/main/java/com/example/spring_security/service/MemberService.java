package com.example.spring_security.service;

import com.example.spring_security.entity.Member;

public interface MemberService {

    int addMember(Member member);

    Member findById(Member member);

}
