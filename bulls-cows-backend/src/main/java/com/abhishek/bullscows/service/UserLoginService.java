package com.abhishek.bullscows.service;

import com.abhishek.bullscows.dto.LoginRequest;
import com.abhishek.bullscows.dto.LoginResponse;
import com.abhishek.bullscows.entity.User;
import com.abhishek.bullscows.exception.InValidCredentialsException;
import com.abhishek.bullscows.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserLoginService {
    private UserRepository userRepository;

    UserLoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public LoginResponse login(LoginRequest request){
        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if(!user.isPresent()){
            throw new InValidCredentialsException("Invalid Email or Password");
        }
        User existingUser = user.get();
        if(!existingUser.getPassword().equals(request.getPassword())){
            throw new InValidCredentialsException("Invalid Email or Password");
        }
        LoginResponse response = new LoginResponse();
        response.setMessage("User Logged in Successfully");
        return response;
    }
}
