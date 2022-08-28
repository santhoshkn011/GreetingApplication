package com.example.greetingapp.controller;

import com.example.greetingapp.service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greet")
public class GreetingApp {

    @RequestMapping(value = {"","/","/home"}, method = RequestMethod.GET)
    public String greet(){
        return "Hello, this is Santhosh from BridgeLabz";
    }

    @RequestMapping("/query/{name}")
    public String greet1(@PathVariable String name){
        return "<h1><font color=blue>Hello! This is " + name + " From BridgeLabz!!</font></h1>" +
                "</br> <font color=green>Passing name as a path variable.</font>";
    }
    @GetMapping("/query")
    public String getUsers(@RequestParam(value = "name", defaultValue = "Santhosh") String name) {
        return "<h1><font color=red>Hello! This is " + name + " From BridgeLabz!!</font></h1>" +
                "</br> <font color=green>Passing name as a parameter.</font>";
    }
    //Getting Greeting message from the Service layer
    @Autowired
    ServiceClass service;
    @GetMapping("/service")
    public String serviceCall(){
        return service.helloWorld();
    }
}