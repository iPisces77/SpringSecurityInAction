package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author fuhaixin
 * @date 2022/10/5
 **/
@Configuration
public class PasswordConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    //    @Bean
    //    public PasswordEncoder passwordEncoder() {
    //        var map = new HashMap<String, PasswordEncoder>();
    //        map.put("noop", NoOpPasswordEncoder.getInstance());
    //        map.put("bcrypt", new BCryptPasswordEncoder());
    //        map.put("scrypt", new SCryptPasswordEncoder());
    //        return new DelegatingPasswordEncoder("bcrypt", map);
    //    }
}
