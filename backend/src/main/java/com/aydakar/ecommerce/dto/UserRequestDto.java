package com.aydakar.ecommerce.dto;

import com.aydakar.ecommerce.enums.Role;

import lombok.Data;

@Data
public class UserRequestDto {
    private String email;
    private String password;
    private Role role;
}
