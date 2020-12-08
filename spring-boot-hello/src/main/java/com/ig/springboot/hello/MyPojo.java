package com.ig.springboot.hello;

import org.springframework.boot.context.properties.ConfigurationProperties;


public class MyPojo {

    private String name;

    private String description;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
