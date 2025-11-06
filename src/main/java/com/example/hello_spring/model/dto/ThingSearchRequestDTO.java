package com.example.hello_spring.model.dto;

public class ThingSearchRequestDTO {
    long id;
    private String name;
    private String kind;
    private String quality;

    public ThingSearchRequestDTO(long id, String name, String kind, String quality) {
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.quality = quality;
    }

    public ThingSearchRequestDTO() {
    }

    //region getters & setters
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

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
    //endregion
}
