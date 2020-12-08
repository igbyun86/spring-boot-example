package com.ig.springboot;

import com.ig.springboot.web.WebController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

@SpringBootTest
public class WebControllerTest {

    @Test
    public void helloTest() {
        // Given
        WebController webController = new WebController();
        Model model = new ExtendedModelMap();

        // When
        webController.hello(model, "ingil");

        // Then
        model.asMap().forEach((k,v) ->
                System.out.println("key: " + k + " / value: " + v));
    }

}
