package com.balestero.githubrepos.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepositoryList {

    List<GithubRepository> items;

    public List<GithubRepository> getItems() {
        return items;
    }

    public void setItems(List<GithubRepository> items) {
        this.items = items;
    }
}
