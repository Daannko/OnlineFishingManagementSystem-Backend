package com.ofms.services;

import com.ofms.configuration.JwtService;
import com.ofms.dto.AuthRequest;
import com.ofms.dto.AuthResponse;
import com.ofms.dto.LoginResponse;
import com.ofms.dto.RegisterRequest;
import com.ofms.models.Role;
import com.ofms.models.User;
import com.ofms.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthResponse register(RegisterRequest request) {

        var newUser = User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .verified(true)
                .role(Role.USER)
                .build();
        userRepository.save(newUser);
        return AuthResponse.builder()
                .token(jwtService.generateToken(newUser))
                .build();
    }

    public LoginResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        return LoginResponse.builder()
                .token(jwtService.generateToken(user))
                .id(user.getId())
                .username(user.getEmail())
                .name(user.getName())
                .surname(user.getSurname())
                .role(user.getRole())
                .verified(user.isVerified())
                .build();
    }

    public User getUserFromContext(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
             username = ((UserDetails)principal).getUsername();
        } else {
             username = principal.toString();
        }
        return userRepository.findByEmail(username).orElseThrow( () -> new UsernameNotFoundException("User not found"));
    }

}
