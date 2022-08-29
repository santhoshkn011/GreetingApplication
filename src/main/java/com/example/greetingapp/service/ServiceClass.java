package com.example.greetingapp.service;

import com.example.greetingapp.model.GreetEntity;
import com.example.greetingapp.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceClass {
    @Autowired
    private Repo repository;
    public String helloWorld() {
        return "Hello World!!! :)";
    }

    public String greetMessageWithUser(String firstName, String lastName) {
        if (firstName.isEmpty() && lastName.isEmpty()) {
            return helloWorld();
        } else if (lastName.equals("") && !firstName.equals("")) {
            return "Hello! " + firstName + ", Welcome to the BridgeLabz!";
        } else if (!lastName.equals("") && firstName.equals("")) {
            return "Hello! " + lastName + ", Welcome to the BridgeLabz!";
        }
        return "Hello! " + firstName +" "+ lastName + ", Welcome to the BridgeLabz!";
    }

    public GreetEntity saveMessage(GreetEntity greeting) {
        repository.save(greeting);
        return greeting;
    }

    public Optional<GreetEntity> findById(long id) {
        return repository.findById(id);
    }

    public List<GreetEntity> findAllGreet(){
        return repository.findAll();
    }

    public GreetEntity editGreeting(GreetEntity greeting, long id) {
        GreetEntity existingGreet = repository.findById(id).orElse(null);
        if (existingGreet != null) {
            existingGreet.setMessage(greeting.getMessage());
            return repository.save(existingGreet);
        }
        else
            return null;
    }
}
