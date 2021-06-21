package com.springboot.application;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * ApplicationStartingEvent
 * ApplicationContext 생성전에 이벤트 실행
 * @Bean의 의미가 없기 때문에 SpringApplication에 addListeners를 통해 추가한다.
 */
public class SampleListener implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        System.out.println("=======================");
        System.out.println("Application is starting");
        System.out.println("=======================");
    }
}
