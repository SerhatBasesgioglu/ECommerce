package com.aydakar.ecommerce.dto;

import lombok.Data;

@Data
public class CategoryResponseDto {
    private String name;
    private String parentCategory;
}
