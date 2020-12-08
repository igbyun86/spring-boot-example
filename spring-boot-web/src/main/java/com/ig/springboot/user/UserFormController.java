package com.ig.springboot.user;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserFormController {


    @GetMapping("/user/form")
    public String newUserForm(@ModelAttribute User user, BindingResult error) {
        return "";
    }

    @PostMapping("/users/new")
    public String newUser(@ModelAttribute @Valid User user, BindingResult error) {
        if (error.hasErrors()) {
            return "users/new";
        }

        return "redirect:/users";
    }


}
