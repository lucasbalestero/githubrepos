package com.balestero.githubrepos.service;

import com.balestero.githubrepos.controller.dto.GithubRepository;
import com.balestero.githubrepos.controller.dto.GithubRepositoryList;
import com.balestero.githubrepos.controller.dto.RepositorySummary;
import com.balestero.githubrepos.factory.RepositorySummaryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GithubRepositoryService {

    @Autowired
    private GithubApiService githubApiService;

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

        // https://api.github.com/users/{username}/repos
        // does not bring private repositories
        String url = String.format("https://api.github.com/search/repositories?q=user:%s", username);

        List<GithubRepository> repositories = githubApiService.request(url, token);

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
                            .withFullName(githubRepository.getFullName())
                            .withLanguage(githubRepository.getLanguage())
                            .withName(githubRepository.getName())
                            .withOwner(githubRepository.getOwner())
                            .withUpdatedAt(githubRepository.getUpdatedAt())
                            .build();
                })
                .collect(Collectors.toList());
    }
}
