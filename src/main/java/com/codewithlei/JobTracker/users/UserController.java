package com.codewithlei.JobTracker.users;

import com.codewithlei.JobTracker.common.token.Token;
import com.codewithlei.JobTracker.users.dto.newUser.RequestNewUserDTO;
import com.codewithlei.JobTracker.users.dto.userData.RequestUserAuthDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Token> register(@RequestBody @Valid RequestNewUserDTO request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.register(request));
    }
    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody @Valid RequestUserAuthDTO request){
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.login(request));
    }
}
