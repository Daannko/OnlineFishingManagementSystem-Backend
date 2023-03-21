package com.example.ofms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;


@Data
@AllArgsConstructor
public class LoginRequest {
    @Email
    private final String email;
    private final String password;
}
