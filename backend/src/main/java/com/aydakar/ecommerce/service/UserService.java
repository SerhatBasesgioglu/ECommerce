package com.aydakar.ecommerce.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.aydakar.ecommerce.entity.User;
import com.aydakar.ecommerce.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserDetails getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User savedUser = userRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(user, savedUser, "id");
        return userRepository.save(savedUser);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
