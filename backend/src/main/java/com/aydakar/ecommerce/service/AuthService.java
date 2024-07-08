package com.aydakar.ecommerce.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aydakar.ecommerce.dto.RegisterDto;
import com.aydakar.ecommerce.entity.User;
import com.aydakar.ecommerce.enums.Role;

@Service
public class AuthService implements UserDetailsService {
    private final UserService userService;
    private final CartService cartService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthService(UserService userService, CartService cartService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.cartService = cartService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void register(RegisterDto registerDto) {
        User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(registerDto.getPassword()));
        user.setRole(Role.ADMIN);
        User createdUser = userService.addUser(user);
        cartService.createCart(createdUser);

    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof User user) {
                return user;
            }
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails user = userService.getUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
