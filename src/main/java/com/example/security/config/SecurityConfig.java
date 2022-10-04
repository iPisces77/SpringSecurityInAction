package com.example.security.config;

import com.example.security.model.SecurityUser;
import com.example.security.model.User;
import com.example.security.service.InMemoryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

/**
 * @author fuhaixin
 * @date 2022/9/28
 * ch5
 **/
@Configuration
public class SecurityConfig {
    private final CustomAuthenticationProvider customAuthenticationProvider;

    public SecurityConfig(CustomAuthenticationProvider customAuthenticationProvider) {
        this.customAuthenticationProvider = customAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authenticationProvider(customAuthenticationProvider).build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var user = new User("john", "123", "read");
        var securityUser = new SecurityUser(user);
        return new InMemoryUserDetailsService(List.of(securityUser));
    }
}
