package com.example.security2_241212.security;

import com.example.security2_241212.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * packageName    : com.example.security2_241212.security
 * fileName       : CustomUserDetails
 * author         : 김재홍
 * date           : 24. 12. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 12.        김재홍       최초 생성
 */
public class CustomUserDetails implements UserDetails {

    private Member member;

    CustomUserDetails(Member member) {
        this.member = member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority(){

            private static final long serialVersionUID = 1L;

            @Override
            public String getAuthority() {
                return member.getRole();
            }

        });

        return collection;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getUsername();
    }

    public String getName() {
        return member.getName();
    }

    public String getRole() {
        return member.getRole();
    }

}
