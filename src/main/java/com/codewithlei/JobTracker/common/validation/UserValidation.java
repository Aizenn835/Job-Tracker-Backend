package com.codewithlei.JobTracker.common.validation;

import com.codewithlei.JobTracker.users.UserRepository;
import com.codewithlei.JobTracker.users.exception.UserAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidation {
    private final UserRepository userRepository;

    public void validateUser(String email){
        if(userRepository.existsByEmail(email)){
            throw new UserAlreadyExistException();
        }
    }
}
