package com.example.security.config;

import com.example.security.filter.StaticKeyAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author fuhaixin
 * @date 2022/9/28
 * ch5
 **/
@Configuration
public class SecurityConfig {
    @Autowired
    private StaticKeyAuthenticationFilter staticKeyAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.addFilterAt(staticKeyAuthenticationFilter, BasicAuthenticationFilter.class)
                .authorizeHttpRequests()
                .anyRequest()
                .permitAll()
                .and()
                .build();
    }
}
