package com.example.examplerestteamplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExampleRestTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleRestTemplateApplication.class, args);
    }

}
