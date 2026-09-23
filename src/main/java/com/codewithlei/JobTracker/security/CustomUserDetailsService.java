package com.codewithlei.JobTracker.security;

import com.codewithlei.JobTracker.users.UserRepository;
import com.codewithlei.JobTracker.users.Users;
import com.codewithlei.JobTracker.users.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String email){
       Users user = userRepository.findByEmail(email)
               .orElseThrow(UserNotFoundException::new);

       return User.builder()
               .username(user.getUsername())
               .roles(user.getRole().name())
               .build();
    }
}
