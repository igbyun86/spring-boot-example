package com.springboot.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@TestPropertySource(locations = "classpath:/test.properties")
@SpringBootTest//(properties = {"ig.name=ig2"})
class ConfigApplicationTests {

    @Autowired
    Environment environment;

    @Test
    @DisplayName("application.properties 우선순위 테스트")
    void contextLoads() {
        assertThat(environment.getProperty("ig.name"), is("ig2"));

    }

}
