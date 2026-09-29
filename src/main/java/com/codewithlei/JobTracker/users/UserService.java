package com.codewithlei.JobTracker.users;

import com.codewithlei.JobTracker.common.token.Token;
import com.codewithlei.JobTracker.common.validation.UserValidation;
import com.codewithlei.JobTracker.security.JwtAuthService;
import com.codewithlei.JobTracker.users.dto.newUser.RequestNewUserDTO;
import com.codewithlei.JobTracker.users.dto.userData.RequestUserAuthDTO;
import com.codewithlei.JobTracker.users.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final UserValidation userValidation;
    private final PasswordEncoder passwordEncoder;
    private final JwtAuthService jwtAuthService;
    private final UserMapper userMapper;
    private final String defaultImg;


    public UserService(AuthenticationManager authenticationManager ,
                       UserRepository userRepository ,
                       UserValidation userValidation ,
                       PasswordEncoder passwordEncoder ,
                       UserMapper userMapper ,
                       JwtAuthService jwtAuthService ,
                       @Value("${app.upload.default.img}") String defaultImg){
        this.userRepository = userRepository;
        this.userValidation = userValidation;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.defaultImg = defaultImg;
        this.jwtAuthService = jwtAuthService;
        this.authenticationManager = authenticationManager;
    }

    @Transactional(rollbackFor = Exception.class)
    public Token register(RequestNewUserDTO request){
        userValidation.validateUser(request.getEmail());

        UserEntity user = userMapper.mapToEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setImgUrl(defaultImg);

        UserEntity saved = userRepository.save(user);
        String token = jwtAuthService.generateToken(saved.getEmail() ,
                                                    saved.getRole().name());
        return new Token(token);
    }
    @Transactional(rollbackFor =  Exception.class)
    public Token login(RequestUserAuthDTO request) throws AuthenticationException {
        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(UserNotFoundException::new);

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail() ,
                                                        request.getPassword())
        );
        String token = jwtAuthService.generateToken(user.getEmail() ,
                                                    user.getRole().name());
        return new Token(token);
    }
}
