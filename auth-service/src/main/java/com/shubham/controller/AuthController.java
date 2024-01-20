package com.shubham.controller;

import com.shubham.dto.AuthRequest;
import com.shubham.entity.User;
import com.shubham.repository.UserRepository;
import com.shubham.service.AuthService;
import com.shubham.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/register")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        log.info("AuthController::addNewUser :{}",user);
        User savedUser = authService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }


    @GetMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        log.info("AuthController::getToken :{}",authRequest);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtUtil.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

    @GetMapping("/validate")
    public String validateTokenAndGetClaims(@RequestParam("token") String token){
        log.info("AuthController::validateTokenAndGetClaims :{}",token);
        jwtUtil.validateToken(token);
        return "Token validated";
    }
}
