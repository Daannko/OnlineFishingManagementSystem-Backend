package com.example.ofms.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class LoginRequest {
    @Email
    private final String email;
    private final String password;
}
