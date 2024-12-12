package com.example.security2_241212.security;

import com.example.security2_241212.dao.MemberDao;
import com.example.security2_241212.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.example.security2_241212.security
 * fileName       : CustomUserDetailsService
 * author         : 김재홍
 * date           : 24. 12. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 12.        김재홍       최초 생성
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    MemberDao memberDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberDao.findByUsername(username); // Member class를 만든다.

        return new CustomUserDetails(member);  // CustomUserDetails를 만든다.;
    }
}
