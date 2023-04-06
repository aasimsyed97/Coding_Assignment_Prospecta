package com.masai.question1.modeldto;

public class EntryDetailsResponseDto {
    private String api;

    private String link;

    private String description;

    private String auth;

    private boolean HTTPS;

    private String cors;

    private String category;

    public EntryDetailsResponseDto() {
    }

    public EntryDetailsResponseDto(String api, String link, String description, String auth, boolean HTTPS, String cors, String category) {
        this.api = api;
        this.link = link;
        this.description = description;
        this.auth = auth;
        this.HTTPS = HTTPS;
        this.cors = cors;
        this.category = category;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public boolean isHTTPS() {
        return HTTPS;
    }

    public void setHTTPS(boolean HTTPS) {
        this.HTTPS = HTTPS;
    }

    public String getCors() {
        return cors;
    }

    public void setCors(String cors) {
        this.cors = cors;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
