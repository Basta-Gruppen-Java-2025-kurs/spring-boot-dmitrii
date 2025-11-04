package com.example.hello_spring;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;

@RestController
public class InfoController {
    @GetMapping("/info")
    public String info() {
        return "Spring Boot makes Java web apps easy!";
    }

    public record Course(String name, String teacher) {}

    @GetMapping("/course")
    public Course course() {
        return new Course("Java deep", "Your teacher");
    }

    @GetMapping("/time")
    public String currentTime() {
        return LocalDateTime.now().toString();
    }

    @GetMapping("/hi/{name}")
    public String helloName(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/multi")
    public String getProduct(@RequestParam String n1, @RequestParam(defaultValue = "1") String n2) {
        return "" + Integer.parseInt(n1) * Integer.parseInt(n2);
    }

    public record Person(String name, String address) {}

    @PostMapping(value="/json", consumes="application/json", produces="text/html")
    public String personJSON(@RequestBody Person person, HttpServletResponse response) {
        response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/personData/" + person.name).toUriString());

        return "Name: " + person.name + "<br/>\n" + person.address;
    }

}
