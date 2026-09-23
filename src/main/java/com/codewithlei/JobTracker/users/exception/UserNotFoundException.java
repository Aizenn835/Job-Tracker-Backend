package com.codewithlei.JobTracker.users.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User not found 404");
    }
    public UserNotFoundException(String message) {
        super(message);
    }
}
