package com.kranthi.loginpage.controller;

import com.kranthi.loginpage.dto.LoginRequest;
import com.kranthi.loginpage.entity.User;
import com.kranthi.loginpage.repository.UserRepository;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    
   @PostMapping("/register")
public ResponseEntity<?> register(@RequestBody User user) {

    User existingUser = userRepository.findByUsername(user.getUsername());

    if (existingUser != null) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Username already exists");
    }

    userRepository.save(user);

    return ResponseEntity.ok("Registration successful");
}


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername());

        if (user != null && user.getPassword().equals(request.getPassword())) {
            return ResponseEntity.ok(user);
        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Invalid username or password");
    }
}
