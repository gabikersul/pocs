package com.gabikersul.cloud.tema10.twittergithub.controller;

import com.gabikersul.cloud.tema10.twittergithub.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/counter")
public class CounterController {

    @Autowired
    private CounterService counterService;

    @RequestMapping(value = "/{githubUser}/{twitterUser}")
    @ResponseBody
    public Map<String, Integer> getUserTotalTweetsAndRepos(@PathVariable String githubUser, @PathVariable String twitterUser ){
        Map<String, Integer> totalTweetsAndRepos = new HashMap<>();
        totalTweetsAndRepos.put(githubUser, counterService.getUserTotalRepos(githubUser));
        totalTweetsAndRepos.put(twitterUser, counterService.getUserTotalTweets(twitterUser));
        return totalTweetsAndRepos;
    }

}
