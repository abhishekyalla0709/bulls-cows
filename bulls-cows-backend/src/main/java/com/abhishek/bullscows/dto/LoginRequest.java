package com.abhishek.bullscows.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotBlank(message = "email cannot be empty")
    @Email
    private String email;
    @NotBlank(message = "password cannot be empty")
    private String password;
}
