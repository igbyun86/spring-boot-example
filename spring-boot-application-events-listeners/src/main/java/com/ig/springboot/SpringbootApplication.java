package com.ig.springboot;

import com.ig.springboot.listener.CustomApplicationContextInitializedEventListener;
import com.ig.springboot.listener.CustomApplicationFailedEventListener;
import com.ig.springboot.listener.CustomApplicationStartedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(SpringbootApplication.class);

        /**
         * add Application listener event
         */
        CustomApplicationContextInitializedEventListener customApplicationContextInitializedEventListener = new CustomApplicationContextInitializedEventListener();
        CustomApplicationStartedEventListener customApplicationStartedEventListener = new CustomApplicationStartedEventListener();
        CustomApplicationFailedEventListener customApplicationFailedEventListener = new CustomApplicationFailedEventListener();
        app.addListeners(
                customApplicationContextInitializedEventListener,
                customApplicationStartedEventListener,
                customApplicationFailedEventListener);

        app.run(args);

    }
}
