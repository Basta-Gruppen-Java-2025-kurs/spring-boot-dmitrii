package com.example.hello_spring.model;

import java.util.List;

public class Thing {
    private long id;
    private String name;
    private String kind;
    private List<String> qualities;

    public Thing(long id, String name, String kind, List<String> qualities) {
        this.name = name;
        this.id = id;
        this.kind = kind;
        this.qualities = qualities;
    }

    public Thing() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<String> getQualities() {
        return qualities;
    }

    public void setQualities(List<String> qualities) {
        this.qualities = qualities;
    }
}
