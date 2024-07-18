package com.example.tinder.exception;

public class PasswordOrEmailNotCorrectException extends RuntimeException{
    public PasswordOrEmailNotCorrectException(String message) {
        super(message);
    }
}
