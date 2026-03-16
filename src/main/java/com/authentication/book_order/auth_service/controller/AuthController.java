package com.authentication.book_order.auth_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.book_order.auth_service.dto.LoginRequest;
import com.authentication.book_order.auth_service.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        if ("admin".equals(request.getUsername()) &&
            "password".equals(request.getPassword())) {

            return JwtUtil.generateToken(request.getUsername());
        }

        throw new RuntimeException("Invalid credentials");
    }
}
