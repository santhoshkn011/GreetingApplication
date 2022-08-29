package com.example.greetingapp.controller;

import com.example.greetingapp.model.GreetEntity;
import com.example.greetingapp.service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greet")
public class GreetingApp {
    @Autowired
    ServiceClass service;

    @RequestMapping(value = {"", "/", "/home"}, method = RequestMethod.GET)
    public String greet() {
        return "Hello, this is Santhosh from BridgeLabz";
    }

    @RequestMapping("/query/{name}")
    public String greet1(@PathVariable String name) {
        return "<h1><font color=blue>Hello! This is " + name + " From BridgeLabz!!</font></h1>" +
                "</br> <font color=green>Passing name as a path variable.</font>";
    }

    @GetMapping("/query")
    public String getUsers(@RequestParam(value = "name", defaultValue = "Santhosh") String name) {
        return "<h1><font color=red>Hello! This is " + name + " From BridgeLabz!!</font></h1>" +
                "</br> <font color=green>Passing name as a parameter.</font>";
    }
    /*
    Extending GreetingController to use Services Layer to get Simple Greeting message
     */

    @GetMapping("/service")
    public String serviceCall() {
        return service.helloWorld();
    }

    //Ability for the Greeting App to give Greeting message
    @GetMapping("/user")
    public String greetMessageWithUser(@RequestParam(value = "firstName", defaultValue = "") String firstName,
                                       @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        return service.greetMessageWithUser(firstName, lastName);
    }

    @PostMapping("/post")
    public GreetEntity addGreeting(@RequestBody GreetEntity greetings) {
        service.saveMessage(greetings);
        return greetings;
    }
}