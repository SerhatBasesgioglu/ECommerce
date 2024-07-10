package com.aydakar.ecommerce.service;

import org.springframework.stereotype.Service;

import com.aydakar.ecommerce.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
