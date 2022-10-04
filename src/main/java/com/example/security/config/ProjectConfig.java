package com.example.security.config;

import com.example.security.model.SecurityUser;
import com.example.security.model.User;
import com.example.security.service.InMemoryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * @author fuhaixin
 * @date 2022/10/5
 **/
// @Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        var user = new User("john", "12345", "read");
        var securityUser = new SecurityUser(user);
        return new InMemoryUserDetailsService(List.of(securityUser));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
