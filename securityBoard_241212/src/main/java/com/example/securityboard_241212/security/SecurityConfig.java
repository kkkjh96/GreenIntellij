package com.example.securityboard_241212.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * packageName    : com.example.securityboard_241212.security
 * fileName       : SecurityConfig
 * author         : GGG
 * date           : 24. 12. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 12. 12.        GGG       최초 생성
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/", "/regist", "/login").permitAll()
                        .requestMatchers("/board/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                );

        http
                .formLogin((auth) -> auth
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/board/list")
                        .permitAll()
                );

        http
                .logout((auth) -> auth
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                );

        http
                .csrf(auth -> auth.disable());

        return http.build();
    }

}
