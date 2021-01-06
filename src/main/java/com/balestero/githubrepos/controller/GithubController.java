package com.balestero.githubrepos.controller;


import com.balestero.githubrepos.controller.dto.GithubUser;
import com.balestero.githubrepos.controller.dto.RepositorySummary;
import com.balestero.githubrepos.service.GithubService;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.Date;
import java.util.List;

@RestController
public class GithubController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private GithubService githubService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<List<RepositorySummary>> list(@RequestBody GithubUser githubUser) {
        List<RepositorySummary> repositories = githubService.listRepositories(githubUser.getUsername(), githubUser.getPassword());
        return ResponseEntity.ok(repositories);
    }



}
