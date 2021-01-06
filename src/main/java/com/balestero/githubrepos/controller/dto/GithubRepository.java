package com.balestero.githubrepos.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepository {

    @JsonProperty("private")
    private Boolean privateRepo;

    @JsonProperty("created_at")
    private String createdAt;

    private String description;

    @JsonProperty("full_name")
    private String fullName;

    private String language;

    @JsonProperty("owner")
    private RepositoryOwner owner;

    private String name;

    @JsonProperty("updated_at")
    private String updatedAt;

    public Boolean getPrivate() {
        return privateRepo;
    }

    public void setPrivate(Boolean privateRepo) {
        this.privateRepo = privateRepo;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public RepositoryOwner getOwner() {
        return owner;
    }

    public void setOwner(RepositoryOwner owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
