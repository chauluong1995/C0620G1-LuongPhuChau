package com.sprint1backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Sprint1BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sprint1BackendApplication.class, args);
    }

}
