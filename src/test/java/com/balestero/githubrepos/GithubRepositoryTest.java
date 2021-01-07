package com.balestero.githubrepos;

import com.balestero.githubrepos.controller.dto.RepositorySummary;
import com.balestero.githubrepos.exception.InvalidTokenException;
import com.balestero.githubrepos.exception.UsernameNotFoundException;
import com.balestero.githubrepos.service.GithubRepositoryService;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
public class GithubRepositoryTest {


    @Autowired
    GithubRepositoryService githubRepositoryService;

    @Test
    public void is_github_api_up() {
        RestTemplate restTemplate = new RestTemplate();
        String resourceURL
                = "https://api.github.com/zen";
        ResponseEntity<String> response
                = restTemplate.getForEntity(resourceURL, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void should_list_user_repositories_when_username_is_provided() {
        List<RepositorySummary> repositorySummaries = githubRepositoryService.listRepositories("lucasbalestero");

        assertThat(repositorySummaries.size(), Matchers.greaterThan(0));
    }

    @Test
    public void should_throw_exception_if_username_is_not_found() {
        Assertions.assertThrows(UsernameNotFoundException.class, () -> githubRepositoryService.listRepositories("1j348tj193248tj"));
    }

    @Test
    public void should_throw_exception_if_token_is_invalid() {
        Assertions.assertThrows(InvalidTokenException.class, () -> githubRepositoryService.listRepositories("1j348tj193248tj", "11"));
    }

}
