package com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {
/*

    @Value("${ig.fullName}")
    private String name;

    @Value("${ig.age}")
    private int age;
*/

    @Autowired
    IgProperties igProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("==================");
        System.out.println(igProperties.getName());
        System.out.println(igProperties.getAge());
        System.out.println(igProperties.getSessionTimeout());
        System.out.println("==================");
    }
}
