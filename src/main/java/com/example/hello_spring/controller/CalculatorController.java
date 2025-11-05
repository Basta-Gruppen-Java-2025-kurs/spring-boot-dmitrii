package com.example.hello_spring.controller;

import com.example.hello_spring.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/calc")
public class CalculatorController {
    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public String add(@RequestParam String n1, @RequestParam String n2) {
        return service.add(Integer.parseInt(n1), Integer.parseInt(n2));
    }

    @GetMapping("/sub")
    public String sub(@RequestParam String n1, @RequestParam String n2) {
        return service.sub(Integer.parseInt(n1), Integer.parseInt(n2));
    }

    @GetMapping("/mul")
    public String mul(@RequestParam String n1, @RequestParam String n2) {
        return service.mul(Integer.parseInt(n1), Integer.parseInt(n2));
    }

    @GetMapping("/div")
    public String div(@RequestParam String n1, @RequestParam String n2) {
        return service.div(Integer.parseInt(n1), Integer.parseInt(n2));
    }

    @GetMapping("/all")
    public HashMap<String, String> all(@RequestParam String n1, @RequestParam String n2) {
        return service.all(Integer.parseInt(n1), Integer.parseInt(n2));
    }

}
