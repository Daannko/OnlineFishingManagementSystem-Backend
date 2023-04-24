package com.ofms.controllers;

import com.ofms.dto.AuthRequest;
import com.ofms.dto.AuthResponse;
import com.ofms.dto.RegisterRequest;
import com.ofms.models.User;
import com.ofms.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){

       return ResponseEntity.ok(authService.register(request));
    }

    //You can use this as login
    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request){
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUser(){
        return ResponseEntity.ok(authService.getUserFromToken());
    }
}
