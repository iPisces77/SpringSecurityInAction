package com.example.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringSecurityInActionApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringSecurityInActionApplication.class, args);
    }
}
