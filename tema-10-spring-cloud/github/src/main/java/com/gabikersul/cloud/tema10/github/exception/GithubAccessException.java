package com.gabikersul.cloud.tema10.github.exception;

public class GithubAccessException extends RuntimeException {
    public GithubAccessException(){
        super("Access to Github Server is not available, try again later.");
    }
}
