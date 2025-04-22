package com.yesterdaysnews.yesterdaysnews.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Integer userId) {
        super("User was not found: " + userId);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
