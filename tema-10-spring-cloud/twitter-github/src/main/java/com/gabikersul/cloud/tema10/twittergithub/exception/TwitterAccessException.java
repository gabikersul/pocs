package com.gabikersul.cloud.tema10.twittergithub.exception;

public class TwitterAccessException extends RuntimeException {
    public TwitterAccessException(){
        super("Access to Twitter Server is not available, try again later.");
    }
}
