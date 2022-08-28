package com.example.greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceClass {
    public String helloWorld(){
        return "Hello World! From the Service layer";
    }
}
