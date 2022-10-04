package com.example.security;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.keygen.KeyGenerators;

@SpringBootTest
class SpringSecurityInActionApplicationTests {

    @Test
    void contextLoads() {
        var stringKeyGenerator = KeyGenerators.string();
        System.out.println(stringKeyGenerator.generateKey());

        var bytesKeyGenerator = KeyGenerators.secureRandom();
        System.out.println(bytesKeyGenerator.generateKey());
        System.out.println(bytesKeyGenerator.getKeyLength());

        var shared = KeyGenerators.shared(8);
        var key1 = shared.generateKey();
        var key2 = shared.generateKey();
        Assertions.assertThat(key1).isEqualTo(key2);
    }
}
