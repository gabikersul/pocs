package com.gabikersul.cloud.tema10.twittergithub.service;

import com.gabikersul.cloud.tema10.twittergithub.exception.GithubAccessException;
import com.gabikersul.cloud.tema10.twittergithub.exception.TwitterAccessException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CounterService {
    private static final String GITHUB_URL_SERVICE = "http://localhost:8080/github/";
    private static final String TWITTER_URL_SERVICE = "http://localhost:8081/twitter/";

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultUserRepos" )
    public Integer getUserTotalRepos(String githubUser){
        try{
            return restTemplate.getForObject(GITHUB_URL_SERVICE + githubUser, Integer.class);
        } catch (HttpClientErrorException e){
            throw new ResponseStatusException(e.getStatusCode(), "Error: " + e.getMessage());
        }catch (ResourceAccessException e){
            throw new GithubAccessException();
        }
    }

    private Integer defaultUserRepos(String user){
        return 0;
    }

    @HystrixCommand(fallbackMethod = "defaultUserTotalTweets")
    public Integer getUserTotalTweets(String twitterUser){
        try{
            return restTemplate.getForObject(TWITTER_URL_SERVICE + twitterUser, Integer.class);
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(e.getStatusCode(), "Error: " + e.getMessage());
        }catch (ResourceAccessException e){
            throw new TwitterAccessException();
        }
    }

    private Integer defaultUserTotalTweets (String user){
        return 0;
    }
}
