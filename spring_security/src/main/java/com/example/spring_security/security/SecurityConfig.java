package com.example.spring_security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests((auth) -> auth
                    .requestMatchers("/", "/p1", "/p2", "/registForm", "/regist", "/login").permitAll()
                    .requestMatchers("/members/**").hasAnyRole("ADMIN", "MEMBER")
                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
            );

        http
            .formLogin((auth) -> auth
                    .permitAll()
            );

        http
            .logout(auth -> auth
                    .logoutSuccessUrl("/")
            );

        http
            .csrf(auth -> auth
                    .disable()
            );

        return http.build();

    }

}
