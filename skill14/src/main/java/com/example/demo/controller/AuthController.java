package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private UserService service;
    // Register API
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        service.register(user);
        return "User Registered Successfully";
    }
    // Login API
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return service.login(user.getUsername(), user.getPassword());
    }
    // Profile API
    @GetMapping("/profile/{username}")
    public User getProfile(@PathVariable String username) {
        return service.getProfile(username);
    }
}