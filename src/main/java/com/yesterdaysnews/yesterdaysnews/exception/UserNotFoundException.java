package com.yesterdaysnews.yesterdaysnews.exception;

public class UserNotFoundException extends RuntimeException {

    // Constructor que acepta un Integer
    public UserNotFoundException(Integer userId) {
        super("User was not found: " + userId);
    }

    // Constructor que acepta un String
    public UserNotFoundException(String message) {
        super(message);
    }
}
