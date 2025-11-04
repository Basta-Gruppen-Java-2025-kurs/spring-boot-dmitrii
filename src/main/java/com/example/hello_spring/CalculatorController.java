package com.example.hello_spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CalculatorController {

    @Value("${calc.factor}")
    String factorS="1";

    CalculatorService calculatorService = new CalculatorService(Integer.parseInt(factorS));

    @GetMapping("/calc/add")
    public String add(@RequestParam String n1, @RequestParam String n2) {
        return calculatorService.add(Integer.parseInt(n1), Integer.parseInt(n2));
    }

    @GetMapping("/calc/sub")
    public String sub(@RequestParam String n1, @RequestParam String n2) {
        return calculatorService.sub(Integer.parseInt(n1), Integer.parseInt(n2));
    }

    @GetMapping("/calc/mul")
    public String mul(@RequestParam String n1, @RequestParam String n2) {
        return calculatorService.mul(Integer.parseInt(n1), Integer.parseInt(n2));
    }

    @GetMapping("/calc/div")
    public String div(@RequestParam String n1, @RequestParam String n2) {
        return calculatorService.div(Integer.parseInt(n1), Integer.parseInt(n2));
    }

    @GetMapping("/calc/all")
    public HashMap<String, String> all(@RequestParam String n1, @RequestParam String n2) {
        return calculatorService.all(Integer.parseInt(n1), Integer.parseInt(n2));
    }

}
