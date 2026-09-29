package com.codewithlei.JobTracker.users;

import com.codewithlei.JobTracker.users.dto.newUser.RequestNewUserDTO;
import com.codewithlei.JobTracker.users.enums.Roles;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class UserMapper {

    public UserEntity mapToEntity(RequestNewUserDTO request){
        LocalDateTime now = LocalDateTime.now();
        return UserEntity.builder()
                .username(request.getUsername())
                .firstName(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(Roles.USER)
                .accountType(request.getAccountType())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }
}
