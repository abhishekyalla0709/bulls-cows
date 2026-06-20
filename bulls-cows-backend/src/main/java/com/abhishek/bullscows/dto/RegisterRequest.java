package com.abhishek.bullscows.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Should be in proper email format")
    private String email;

    @NotBlank(message = "Password should not be empty")
    @Size(min = 6, message = "Password size should be min of 6 characters")
    private String password;
}
