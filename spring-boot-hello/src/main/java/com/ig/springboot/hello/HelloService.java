package com.ig.springboot.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HelloService {

    //@Autowired
    //private ApplicationArguments arguments;

    @Value("${hello:default value}")
    private String[] values;
/*
    @Value("${ig.name}")
    private String name;

    @Value("${myPojo}")
    List<MyPojo> myPojoList;
*/
    @Autowired
    private IgProperties igProperties;

    @Value("${ig.number2}")
    private int number2;

    /**
     * --hello=Hello -hello=World
     * @return
     */
    public String getMessage() {
        //List<String> helloValues = arguments.getOptionValues("hello");
        //String collect = helloValues.stream().collect(Collectors.joining(","));

        //igProperties.getMyPojoList().stream().forEach((m) -> System.out.println("name: " + m.getName() + " descr :" + m.getDescription()));

        System.out.println(number2);


        //return collect;
        //return "Hello Spring Boot 2.0";
        //return Arrays.stream(values).collect(Collectors.joining(","));
        return "Hello, " + igProperties.getName() + " " + igProperties.getMyPojoList().size();
    }


}
