package com.springboot.example;

import com.springboot.igspringbootstarter.Holoman;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * bean을 등록하는 순서
 * 1. @ComponentScan
 * 2. @EnableAutoConfiguration
 */
@SpringBootApplication
public class ExampleApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ExampleApplication.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

/*
    // @EnableAutoConfiguration 이 동작하기전 @ComponentScan으로 bean등록하기
    @Bean
    public Holoman holoman() {
        Holoman holoman = new Holoman();
        holoman.setName("ingil");
        holoman.setHowLong(30);
        return holoman;
    }
    */
}
