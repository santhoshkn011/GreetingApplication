package com.example.greetingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(GreetingAppApplication.class, args);
        System.out.println("Hello World!");
    }
}
