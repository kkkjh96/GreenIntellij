package com.example.spring_security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {

    @Id
    private String username;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String role;

}