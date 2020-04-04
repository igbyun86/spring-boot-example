package com.ig.springbootbanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBannerApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootBannerApplication.class);
        // banner off
        //app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
