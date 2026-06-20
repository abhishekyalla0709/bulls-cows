package com.abhishek.bullscows.controller;

import com.abhishek.bullscows.dto.LoginRequest;
import com.abhishek.bullscows.dto.LoginResponse;
import com.abhishek.bullscows.dto.RegisterRequest;
import com.abhishek.bullscows.dto.RegisterResponse;
import com.abhishek.bullscows.service.UserLoginService;
import com.abhishek.bullscows.service.UserRegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRegistrationService userRegistrationService;
    private final UserLoginService userLoginService;
    public UserController(UserRegistrationService userRegistrationService, UserLoginService userLoginService){
        this.userRegistrationService = userRegistrationService;
        this.userLoginService = userLoginService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest registerRequest){
        RegisterResponse response = userRegistrationService.register(registerRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest){
        LoginResponse response = userLoginService.login(loginRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

}
