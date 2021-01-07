package com.balestero.githubrepos.controller;


import com.balestero.githubrepos.controller.dto.GithubUser;
import com.balestero.githubrepos.controller.dto.RepositorySummary;
import com.balestero.githubrepos.service.GithubRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GithubController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private GithubRepositoryService githubRepositoryService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<List<RepositorySummary>> list(@RequestBody(required = true) GithubUser githubUser) {
        if (githubUser.getUsername() == null) {
            throw new IllegalArgumentException("Username must be provided");
        }
        if (githubUser.getPassword() == null) {
            throw new IllegalArgumentException("Password must be provided");
        }
        List<RepositorySummary> repositories = githubRepositoryService.listRepositories(githubUser.getUsername(), githubUser.getPassword());
        return ResponseEntity.ok(repositories);
    }



}
