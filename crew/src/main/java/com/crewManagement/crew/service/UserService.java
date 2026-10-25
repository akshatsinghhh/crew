
package com.crewManagement.crew.service;

import com.crewManagement.crew.entity.UserEntity;
import com.crewManagement.crew.Repo.UserRepository;
import com.crewManagement.crew.Security.JwtService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    // Register a new user
    public UserEntity registerUser(UserEntity user) {

        String encodedPassword =
                passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        return userRepository.save(user);
    }

    // Login an existing user

    public String loginUser(String username, String password) {

        UserEntity user = userRepository.findByUsername(username);

        System.out.println("User found: " + (user != null));

        if (user != null) {
            System.out.println("Password matches: "
                    + passwordEncoder.matches(password, user.getPassword()));
        }

        if (user == null) {
            throw new RuntimeException("Invalid username or password");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        return jwtService.generateToken(user.getUsername());
    }

}
