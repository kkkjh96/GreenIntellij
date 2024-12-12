package com.example.security2_241212.service;

import com.example.security2_241212.dao.MemberDao;
import com.example.security2_241212.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public void regist(Member member) {

        String pw = member.getPassword();
        String password = passwordEncoder.encode(pw);

        member.setPassword(password);
        member.setRole("ROLE_MEMBER");

        memberDao.insertMember(member);

    }

    @Override
    public Member findByUserName(String username) {

        Member member;
        member = memberDao.findByUsername(username);

        return member;
    }
}
