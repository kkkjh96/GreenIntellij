package com.example.spring_security.service;

import com.example.spring_security.dao.MemberDao;
import com.example.spring_security.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberDao memberDao;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public int addMember(Member member) {
        // password encryption using BCryptPasswordEncoder
        String encodedPassword = passwordEncoder.encode(member.getPassword()); // password encryption using BCryptPasswordEncoder

        // password encryption using BCryptPasswordEncoder
        member.setPassword(encodedPassword);

        // default role is MEMBER
        member.setRole("ROLE_MEMBER");

        return memberDao.regist(member);
    }

    @Override
    public Member findById(Member member) {

        return null;
    }
}
