package com.abhishek.bullscows.service;

import com.abhishek.bullscows.dto.RegisterRequest;
import com.abhishek.bullscows.dto.RegisterResponse;
import com.abhishek.bullscows.entity.User;
import com.abhishek.bullscows.exception.UserAlreadyExistsException;
import com.abhishek.bullscows.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserRegistrationService {

    private final UserRepository userRepository;

    public UserRegistrationService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public RegisterResponse register(RegisterRequest registerRequest){
        Optional<User> existingUser = userRepository.findByEmail(registerRequest.getEmail());
        if (existingUser.isPresent()){
            throw new UserAlreadyExistsException("User with email " + registerRequest.getEmail() + " exists");
        }
        User user = new User();
        user.setCreatedAt(LocalDateTime.now());
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());

        User savedUser = userRepository.save(user);
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setId(savedUser.getId());
        registerResponse.setName(savedUser.getName());
        registerResponse.setEmail(savedUser.getEmail());
        registerResponse.setMessage("user created successfully");

        return registerResponse;
    }


}
