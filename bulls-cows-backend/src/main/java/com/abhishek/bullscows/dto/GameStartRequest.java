package com.abhishek.bullscows.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameStartRequest {

    @NotBlank(message = "email should not be empty")
    @Email
    private String email;
}
