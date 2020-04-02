package com.ig.springboot.listener;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

public class CustomApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent> {
    @Override
    public void onApplicationEvent(ApplicationFailedEvent applicationFailedEvent) {

        System.out.println("===== ApplicationFailedEventListener =====");
        System.out.println(applicationFailedEvent.getException());
    }
}
