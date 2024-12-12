package com.example.security2_241212.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    private String username;
    private String password;
    private String name;
    private String role; // ROLE_USER or ROLE_ADMIN

}
