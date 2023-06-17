package com.ofms.controllers;

import com.ofms.AOP.MaxWeight;
import com.ofms.dto.AuthRequest;
import com.ofms.dto.AuthResponse;
import com.ofms.dto.LoginResponse;
import com.ofms.dto.RegisterRequest;
import com.ofms.models.User;
import com.ofms.repositories.UserRepository;
import com.ofms.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository;

    public AuthController(AuthService authService, UserRepository userRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
    }

    @MaxWeight
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){

        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body("User with that email already exists");
        }

       return ResponseEntity.ok(authService.register(request));
    }

    //You can use this as login
    @PostMapping("/authenticate")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody AuthRequest request){
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUser(){
        return ResponseEntity.ok(authService.getUserFromContext());
    }
}
