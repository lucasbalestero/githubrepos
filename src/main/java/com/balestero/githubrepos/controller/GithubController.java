package com.balestero.githubrepos.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GithubController {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String list() {
        return "works";
    }

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String health() {
        return "ok";
    }
}
