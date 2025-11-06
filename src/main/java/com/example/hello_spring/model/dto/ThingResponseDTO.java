package com.example.hello_spring.model.dto;

public class ThingResponseDTO {
    private long id;
    private String name;
    private String kind;
    private String[] qualities;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String[] getQualities() {
        return qualities;
    }

    public void setQualities(String[] qualities) {
        this.qualities = qualities;
    }
}
