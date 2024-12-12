package com.example.securityboard_241212.service;

import com.example.securityboard_241212.dao.MemberDao;
import com.example.securityboard_241212.dto.MemberDto;
import com.example.securityboard_241212.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.example.securityboard_241212.service
 * fileName       : MemberServiceImpl
 * author         : 김재홍
 * date           : 24. 12. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 12.        김재홍       최초 생성
 */
@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {

    @Autowired
    MemberDao memberDao;

    @Autowired
    BCryptPasswordEncoder passwordEncoder; // 비밀번호 암호화를 위한 Bean

    @Override
    public int insertMember(MemberDto member) {
        
        member.setRole("ROLE_USER");
        member.setPassword(passwordEncoder.encode(member.getPassword())); // 비밀번호 암호화

        return memberDao.insertMember(member);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MemberDto member = memberDao.findByUsername(username); // Member class를 만든다.

        return member;  // CustomUserDetails를 만든다.;
    }

}
