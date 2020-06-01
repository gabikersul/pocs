package com.gabikersul.cloud.tema10.github.service;

import com.gabikersul.cloud.tema10.github.exception.GithubAccessException;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class GithubService {
    private static final String GITHUB_API  = "https://api.github.com/users/";

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultUserRepos")
    public int getUserRepositories(String user){
        try {
            String userRepositories = restTemplate.getForObject(GITHUB_API + user + "/repos", String.class);
            JsonArray arrayUserRepos = JsonParser.parseString(userRepositories).getAsJsonArray();
            return arrayUserRepos.size();
        }catch (ResourceAccessException e){
            throw new GithubAccessException();
        }
    }

    private int defaultUserRepos(String user){
        return 0;
    }
}