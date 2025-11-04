package com.example.hello_spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.welcome-message}")
    String message;
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Spring Boobs";
    }

    @GetMapping("/greeting")
    public Greeting greeting() {
        return new Greeting("Welcome to the Spring Boot!", 1);
    }

    @GetMapping("/bye")
    public String Bye() {
        return message;
    }
}
