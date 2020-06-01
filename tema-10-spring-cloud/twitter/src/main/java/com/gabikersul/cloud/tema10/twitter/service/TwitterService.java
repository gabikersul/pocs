package com.gabikersul.cloud.tema10.twitter.service;

import com.gabikersul.cloud.tema10.twitter.TwitterAPI;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.TwitterException;
@Service
public class TwitterService {

    @Autowired
    private TwitterAPI twitterAPI;

    @HystrixCommand(fallbackMethod = "defaultUserTotalTweets")
    public int getUserTotalTweets(String user) throws TwitterException {
        return twitterAPI.getInstanceOfTwitter().showUser(user).getStatusesCount();
    }

    private int defaultUserTotalTweets (String user){
        return 0;
    }
}
