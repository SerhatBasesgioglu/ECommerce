package com.aydakar.ecommerce.dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private long id;
    private String email;
    private String password;
}