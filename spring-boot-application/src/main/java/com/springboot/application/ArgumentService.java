package com.springboot.application;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class ArgumentService {

    /**
     * vmoption: -Dfoo
     * Program arguments: --bar
     * @param arguments
     */
    public ArgumentService(ApplicationArguments arguments) {
        System.out.println("foo: " + arguments.containsOption("foo"));
        System.out.println("bar: " + arguments.containsOption("bar"));

    }
}
