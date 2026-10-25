
package com.crewManagement.crew.controller;

import com.crewManagement.crew.entity.UserEntity;
import com.crewManagement.crew.Dto.LoginRequest;
import com.crewManagement.crew.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Registration API
    @PostMapping("/register")
    public String registerUser(@RequestBody UserEntity user) {

        userService.registerUser(user);

        return "User registered successfully";
    }

    // Login API
    @PostMapping("/login")
    public Map<String, String> loginUser(
            @RequestBody LoginRequest loginRequest) {
        System.out.println("LOGIN CONTROLLER REACHED");

        String token = userService.loginUser(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        );

        Map<String, String> response = new HashMap<String, String>();
        response.put("token", token);

        return response;
    }
}
