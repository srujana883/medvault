package com.medvault.medvault.controller;

import com.medvault.medvault.entity.User;
import com.medvault.medvault.service.JwtService;
import com.medvault.medvault.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.medvault.medvault.dto.LoginRequest;

@RestController
public class UserController {
    private UserService userService;
    private JwtService jwtService;
    public UserController(UserService userService,JwtService jwtService){
        this.userService=userService;
        this.jwtService=jwtService;
    }
    @PostMapping("/api/users")
    public User createUser(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }
    @PostMapping("/api/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        User user=userService.findUserByEmail(loginRequest.getEmail());
        boolean valid = userService.verifyPassword(
                loginRequest.getPassword(),
                user.getPassword()
        );

        if (valid) {
            return jwtService.generateToken(user.getEmail());
        }

        return "Invalid password";
    }
}
