package com.shubham.service;

import com.shubham.entity.User;
import com.shubham.repository.UserRepository;
import com.shubham.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

//    register user
    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String generateToken(String username){
        return jwtUtil.generateToken(username);
    }

    public void validateToken(String token){
        jwtUtil.validateToken(token);
    }
}
