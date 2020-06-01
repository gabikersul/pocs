package com.gabikersul.cloud.tema10.twittergithub.exception;

public class GithubAccessException extends RuntimeException {
    public GithubAccessException(){
        super("Access to Github Server is not available, try again later.");
    }
}
