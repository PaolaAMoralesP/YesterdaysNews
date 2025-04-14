package com.yesterdaysnews;

public class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(Integer userId) {
            super("User was not found: " + userId);
        }
    }

