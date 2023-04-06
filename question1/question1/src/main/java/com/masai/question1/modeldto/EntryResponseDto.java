package com.masai.question1.modeldto;

public class EntryResponseDto {
    private String api;

    private String description;

    public EntryResponseDto() {
    }

    public EntryResponseDto(String api, String description) {
        this.api = api;
        this.description = description;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
