package com.balestero.githubrepos.service;

import com.balestero.githubrepos.controller.dto.GithubRepository;
import com.balestero.githubrepos.controller.dto.GithubRepositoryList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GithubApiService {

    public List<GithubRepository> request(String url, String token) {
        HttpHeaders headers = new HttpHeaders();

        headers.add("Accept", "application/vnd.github.v3+json");

        if (token != null) {
            headers.add("Authorization", "token " + token);
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<>("", headers);

        ResponseEntity<GithubRepositoryList> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, GithubRepositoryList.class);

        return response.getBody().getItems();
    }
}
