package com.gabikersul.cloud.tema10.twittergithub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CounterConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
