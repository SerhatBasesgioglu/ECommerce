package com.aydakar.ecommerce.service;

import com.aydakar.ecommerce.entity.User;
import com.aydakar.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public User registerUser(User user) {
        if (user.getName().equals("serhat")) {
            System.out.println("Input is serhat mate");
        }
        return null;
    }

    public User loginUser(User user) {
        return null;
    }
}
