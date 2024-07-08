package com.aydakar.ecommerce.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aydakar.ecommerce.dto.RegisterDto;
import com.aydakar.ecommerce.service.AuthService;

@RestController
@RequestMapping("auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("register")
    public void register(@RequestBody RegisterDto registerDto) {
        authService.register(registerDto);
    }
}
