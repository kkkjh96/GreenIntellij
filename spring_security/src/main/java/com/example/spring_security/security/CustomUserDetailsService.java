package com.example.spring_security.security;

import com.example.spring_security.dao.MemberDao;
import com.example.spring_security.entity.Member;
import com.example.spring_security.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    //service 어노테이션을 붙여야 한다.

    @Autowired
    private MemberDao memberDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberDao.findByUsername(username);

        return new CustomUserDetails(member);

    }
}
