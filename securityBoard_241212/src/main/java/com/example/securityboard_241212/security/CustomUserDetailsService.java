package com.example.securityboard_241212.security;

import com.example.securityboard_241212.dao.MemberDao;
import com.example.securityboard_241212.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.example.securityboard_241212.security
 * fileName       : CustomUserDetailsService
 * author         : GGG
 * date           : 24. 12. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 12.        GGG       최초 생성
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    MemberDao memberDao;  // MemberDao interface를 DI 받아 memberDao를 memberDao로 ���기화

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MemberDto member = memberDao.findByUsername(username); // Member class를 만든다.

        return new CustomUserDetails(member);  // CustomUserDetails를 만든다.;
    }
}
