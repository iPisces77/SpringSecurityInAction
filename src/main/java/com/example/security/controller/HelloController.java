package com.example.security.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fuhaixin
 * @date 2022/9/28
 **/
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        var context = SecurityContextHolder.getContext();
        var authentication = context.getAuthentication();
        return "Hello World" + authentication.getName();
    }

    @Async
    @GetMapping("/bye")
    public void goodBye() {
        var context = SecurityContextHolder.getContext();
        var authentication = context.getAuthentication();
        System.out.println("Good Bye" + authentication.getName());
    }
}
