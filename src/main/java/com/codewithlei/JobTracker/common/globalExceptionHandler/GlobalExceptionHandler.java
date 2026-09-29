package com.codewithlei.JobTracker.common.globalExceptionHandler;

import com.codewithlei.JobTracker.users.exception.UserAlreadyExistException;
import com.codewithlei.JobTracker.users.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFound(UserNotFoundException e){
        ErrorMessage errorMessage = ErrorMessage.builder()
                .status(404)
                .message(e.getMessage())
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorMessage);
    }
    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<?> handleUserAlreadyExist(UserAlreadyExistException e){
        ErrorMessage errorMessage = ErrorMessage.builder()
                .status(409)
                .message(e.getMessage())
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(errorMessage);
    }
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> handleAuthenticationOnLogin(BadCredentialsException e){
        ErrorMessage errorMessage = ErrorMessage.builder()
                .status(401)
                .message(e.getMessage())
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(errorMessage);
    }
}
