package com.aydakar.ecommerce.controller;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aydakar.ecommerce.dto.UserRequestDto;
import com.aydakar.ecommerce.dto.UserResponseDto;
import com.aydakar.ecommerce.entity.User;
import com.aydakar.ecommerce.service.AuthService;

@RestController
@RequestMapping("auth")
public class AuthController {
    private final AuthService authService;
    private final ModelMapper modelMapper;

    public AuthController(AuthService authService, ModelMapper modelMapper) {
        this.authService = authService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("register")
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        User user = modelMapper.map(userRequestDto, User.class);
        User savedUser = authService.register(user);
        return modelMapper.map(savedUser, UserResponseDto.class);
    }
}
