package com.example.securityboard_241212.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * packageName    : com.example.securityboard_241212.dto
 * fileName       : MemberDto
 * author         : GGG
 * date           : 24. 12. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 12.        GGG       최초 생성
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto implements UserDetails {

    private String username;
    private String password;
    private String name;
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {

            private static final long serialVersionUID = 1L;

            @Override
            public String getAuthority() {
                return getRole();
            }

        });

        return collection;

    }

}
