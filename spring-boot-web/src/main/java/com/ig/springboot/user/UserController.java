package com.ig.springboot.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    HttpMessageConverters converts;

    @RequestMapping("/")
    public String index() {
        // defult converter 확인
        converts.getConverters().forEach(c ->
                System.out.println("::::::::::::::" + c.getClass()));

        return "Hello Spring MVC";
    }

    @GetMapping("/user")
    public User currentUser() {
        User user = new User();
        user.setName("ingil");
        user.setAge(30);
        user.setHeight(170);

        return user;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/users/create")
    public User create(@RequestBody User user) {
        return user;
    }

}
