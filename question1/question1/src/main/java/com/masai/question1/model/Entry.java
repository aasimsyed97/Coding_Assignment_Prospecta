package com.masai.question1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonProperty("API")
    private String api;

    @JsonProperty("Link")
    private String link;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Auth")
    private String auth;

    @JsonProperty("Https")
    private boolean HTTPS;

    @JsonProperty("Cors")
    private String cors;

    @JsonProperty("Category")
    private String category;

    public Entry() {
    }

    public Entry(Integer id, String api, String link, String description, String auth, boolean HTTPS, String cors, String category) {
        this.id = id;
        this.api = api;
        this.link = link;
        this.description = description;
        this.auth = auth;
        this.HTTPS = HTTPS;
        this.cors = cors;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
