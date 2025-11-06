package com.example.hello_spring.model.dto;

public class ThingRequestDTO {
    private String name;
    private String kind;
    private String[] qualities;

    public ThingRequestDTO(String name, String kind, String[] qualities) {
        this.name = name;
        this.kind = kind;
        this.qualities = qualities;
    }

    public ThingRequestDTO() {
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
