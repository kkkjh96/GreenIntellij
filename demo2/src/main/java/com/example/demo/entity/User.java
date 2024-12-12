package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_241210")
public class User {

    @Id
    private String username;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String role;

}
