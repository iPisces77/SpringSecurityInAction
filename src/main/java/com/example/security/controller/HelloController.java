package com.example.security.controller;

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
    return "Hello World";
  }
}
