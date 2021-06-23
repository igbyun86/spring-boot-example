package com.ig.springboot.user;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void createUser_JSON() throws Exception {
        String userJson = "{\"name\":\"ingil\", \"age\":23}";
        mockMvc.perform(post("/users/create")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(userJson)
            )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.equalTo("ingil")))
                .andExpect(jsonPath("$.age", Matchers.equalTo(23)))
        ;

    }

    @Test
    public void createUser_XML() throws Exception {
        String userJson = "{\"name\":\"ingil\", \"age\":23}";
        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_XML)
                .content(userJson)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(xpath("/User/name")
                        .string("ingil"))
                .andExpect(xpath("/User/age")
                        .number((double) 23)
                )
        ;

    }
}
