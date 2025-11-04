package com.example.hello_spring;

import java.util.HashMap;

public class CalculatorService {

    public CalculatorService(int factor) {
        this.factor = factor;
    }

    private final int factor;

    public String add(int n1, int n2) {
        return factor + " " + (n1 + n2) * factor;
    }

    public String sub(int n1, int n2) {
        return "" + (n1 - n2) * factor;
    }

    public String mul(int n1, int n2) {
        return "" + (n1 * n2) * factor;
    }

    public String div(int n1, int n2) {
        return "" + (n1 / n2) * factor;
    }

    public HashMap<String,String> all(int n1, int n2) {
        HashMap<String,String> themAll = new HashMap<>();
        themAll.put("add", add(n1,n2));
        themAll.put("sub", sub(n1,n2));
        themAll.put("mul", mul(n1,n2));
        themAll.put("div", div(n1,n2));
        return themAll;
    }
}
