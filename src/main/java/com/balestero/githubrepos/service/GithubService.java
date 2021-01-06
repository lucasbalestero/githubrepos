package com.balestero.githubrepos.service;

import com.balestero.githubrepos.controller.dto.GithubRepository;
import com.balestero.githubrepos.controller.dto.RepositorySummary;
import com.balestero.githubrepos.factory.RepositorySummaryBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GithubService {

    /**
     * Fetch github's API to create a list of repository summaries.
     *
     * Note that this method has an average limit of 60 requests per minute.
     *
     * This method should be used for testing
     *
     * @param username github's username
     * @return a list of {@link RepositorySummary} with data from github's API
     */
    public List<RepositorySummary> listRepositories(String username) {
        return listRepositories(username, null);
    }

    /**
     * Fetch github's API to create a list of repository summaries.
     *
     * @param username github's username
     * @param token personal access token generated in the Github's Developer settings
     * @return a list of {@link RepositorySummary} with data from github's API
     */
    public List<RepositorySummary> listRepositories(String username, String token) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceURL = String.format("https://api.github.com/users/%s/repos", username);
        ResponseEntity<GithubRepository[]> response = restTemplate.getForEntity(resourceURL, GithubRepository[].class);
        List<GithubRepository> repositories = Arrays.asList(response.getBody());
        return mapGithubReturn(repositories);
    }

    private List<RepositorySummary> mapGithubReturn(List<GithubRepository> repositories) {
        return repositories
                .stream()
                .map(githubRepository -> {
                    RepositorySummaryBuilder builder = new RepositorySummaryBuilder();
                    return builder
                            .withPrivate(githubRepository.getPrivate())
                            .withCreatedAt(githubRepository.getCreatedAt())
                            .withDescription(githubRepository.getDescription())
                            .withLanguage(githubRepository.getLanguage())
                            .withOwner(githubRepository.getOwner())
                            .withUpdatedAt(githubRepository.getUpdatedAt())
                            .build();
                })
                .collect(Collectors.toList());
    }
}
