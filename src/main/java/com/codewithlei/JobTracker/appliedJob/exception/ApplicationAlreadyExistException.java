package com.codewithlei.JobTracker.appliedJob.exception;

public class ApplicationAlreadyExistException extends RuntimeException{
    public ApplicationAlreadyExistException(String message) {
        super(message);
    }

    public ApplicationAlreadyExistException() {
        super("Application Already Exist");
    }
}
