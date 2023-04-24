package com.ofms.controllers;

import com.ofms.models.User;
import com.ofms.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAllUsers();
    }
}
