package com.ofms.dto;

import com.ofms.models.Role;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginResponse {
    private Long id;
    private String username;
    private String name;
    private String surname;
    private Boolean verified;
    private Role role;
    private String token;
}
