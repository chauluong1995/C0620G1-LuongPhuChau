package com.sprint2.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Sprint2BackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sprint2BackEndApplication.class, args);
    }

}
