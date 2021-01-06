package com.balestero.githubrepos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class GithubController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String list() {
        return "works";
    }

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String health() {
        return "ok";
    }



}
